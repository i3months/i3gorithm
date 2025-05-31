// 완탐
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
 
public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Locate> home = new ArrayList<>();
    static ArrayList<Locate> chicken = new ArrayList<>();
    static int ans = 10_000_000; 
    static boolean[] open;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];        
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    home.add(new Locate(i,j));                    
                }

                if(map[i][j] == 2){
                    chicken.add(new Locate(i,j));
                }
            }
        }

        open = new boolean[chicken.size()];

        dfs(0,0);

        System.out.println(ans);
        

        

        
    }

    static void dfs(int start, int cnt){
        if(cnt == M){
            int result = 0;
            for(int i=0; i<home.size(); i++){
                 int chicken_len = Integer.MAX_VALUE;
                for(int j=0; j<chicken.size(); j++){
                    if(open[j]){
                        int dist = Math.abs(home.get(i).r - chicken.get(j).r) + Math.abs(home.get(i).c - chicken.get(j).c);
                        chicken_len = Math.min(chicken_len, dist);
                    }
                }
                result = result + chicken_len;
            }
            ans = Math.min(ans, result);
            return;
        }

        for(int i = start; i<chicken.size(); i++){
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}

class Locate{
    int r, c;
    Locate(int r, int c){
        this.r = r;
        this.c = c;
    }
}