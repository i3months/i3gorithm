// 이중리스트
// import java.util.*;
// import java.io.*;

// public class Main {

//     static int N;        
//     static int M;

//     static int target1;
//     static int target2;

//     static int[] parent;
//     static ArrayList<Integer>[] list;
//     static boolean[] visit;   

//     static int[] dist;
    
//     static StringBuilder sb = new StringBuilder();
        

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         N = Integer.parseInt(br.readLine());

//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int target1 = Integer.parseInt(st.nextToken());
//         int target2 = Integer.parseInt(st.nextToken());

//         int M = Integer.parseInt(br.readLine());
            
//         list = new ArrayList[N+1];
//         parent = new int[N+1];
//         visit = new boolean[N+1];
        
//         for(int i=1; i<N+1; i++){
//             list[i] = new ArrayList<>();
//         }

//         for(int i=0; i<M; i++){
//             st = new StringTokenizer(br.readLine());
//             int a =Integer.parseInt(st.nextToken());
//             int b =Integer.parseInt(st.nextToken());
//             list[a].add(b);
//             list[b].add(a);
//         }

//         dist = new int[N+1];

//         bfs(target1);
        
//         System.out.println(dist[target2]);

//     }

//     static void bfs(int start){
//         Queue<Integer> q = new LinkedList<>();
        
        
//         for(int i=1; i<N+1; i++){
//             dist[i] = -1;
//         }

//         q.add(start);
//         visit[start] = true;
//         dist[start] = 0; 

//         while(!q.isEmpty()){
//             int x = q.poll();
//             for(int y : list[x]){
//                 if(visit[y]){
//                     continue;
//                 }                
                
//                 q.add(y);
//                 dist[y] = dist[x] + 1;
//                 visit[y] = true;
//             }
//         }
//     }
// }