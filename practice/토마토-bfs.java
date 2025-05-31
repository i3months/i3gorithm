// bfs
// import java.io.*;
// import java.util.*;

// public class Main{

//   static int N;
//   static int M;

//   static int[] dx = {-1,1,0,0};
//   static int[] dy = {0,0,-1,1};

//   static int[][] map;

//   static Queue<Tomato> q;
  
//     public static void main(String[] args)throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         M = Integer.parseInt(st.nextToken());
//         N = Integer.parseInt(st.nextToken());

//         map = new int[N][M];

//         q = new LinkedList<>();

//         for(int i=0; i<N; i++){
//           st = new StringTokenizer(br.readLine());
//           for(int j=0; j<M; j++){
//             int temp = Integer.parseInt(st.nextToken());
//             map[i][j] = temp;
//             if(temp == 1){
//               q.add(new Tomato(i,j));
//             }
//           }
//         }

//         System.out.println(bfs());





//     }

//     static class Tomato{
//       int x; 
//       int y;

//       Tomato(int a, int b){
//         x = a;
//         y = b;
//       }
//     }

//     static int bfs(){

//       while(q.isEmpty() == false){
//         Tomato tomato = q.remove();

//         int x = tomato.x;
//         int y = tomato.y;

//         for(int i=0; i<4; i++){
//           int move_x = x + dx[i];
//           int move_y = y + dy[i];
          
//           if(move_x >= 0 && move_y >= 0 && move_x < N && move_y < M){
//             if(map[move_x][move_y] == 0){
//               q.add(new Tomato(move_x, move_y));
//               map[move_x][move_y] = map[x][y] + 1;
//             }
//           }
//         }
//       } // end of while

//       int ans = 0;

//       for(int i=0; i<N; i++){
//         for(int j=0; j<M; j++){
//           if(map[i][j] == 0){
//             return -1;
//           }
//           ans = Math.max(ans, map[i][j]);
//         }
//       } // end of for i

//       return ans -1;



//     }


// }