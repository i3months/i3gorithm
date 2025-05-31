// // 다익
// import java.io.*;
// import java.util.*;
// import java.math.*;

// public class Main {    
//     static StringBuilder sb = new StringBuilder();      
//     static final int INF = 987654321;  
    
//     static int V, E, P;
//     static int[] dist;
//     static ArrayList<Edge>[] list;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         V = Integer.parseInt(st.nextToken());
//         E = Integer.parseInt(st.nextToken());
//         P = Integer.parseInt(st.nextToken());

//         dist = new int[V+1];
//         list = new ArrayList[V+1];

//         for(int i=0; i<V+1; i++) list[i] = new ArrayList<>();

//         for(int i=0; i<E; i++) {
//             st = new StringTokenizer(br.readLine());

//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());
//             int c = Integer.parseInt(st.nextToken());

//             list[a].add(new Edge(b, c));
//             list[b].add(new Edge(a, c));
//         }

//         dijkstra(1);
        
//         int temp = dist[P];
//         int oneRoute = dist[V];

//         dijkstra(P);

//         int temp2 = dist[V];

//         int twoRoute = temp + temp2;

//         if(oneRoute == twoRoute) {
//             System.out.println("SAVE HIM");
//         }else {
//             System.out.println("GOOD BYE");
//         }

        

//     }

//     static void dijkstra(int start) {
//         for(int i=0; i<V+1; i++) dist[i] = INF;

//         dist[start] = 0;
        
//         PriorityQueue<Info> pq = new PriorityQueue<>();

//         pq.add(new Info(start, 0));

//         while(!pq.isEmpty()) {
//             Info info = pq.poll();

//             if(dist[info.idx] < info.dist) continue;
            
//             for(Edge e : list[info.idx]) {
//                 if(dist[info.idx] + e.weight >= dist[e.to]) continue;
//                 dist[e.to] = dist[info.idx] + e.weight;
//                 pq.add(new Info(e.to, dist[e.to]));
//             }
//         }
//     }
// }

// class Edge {
//     int to, weight;

//     Edge(int to, int weight) {
//         this.to = to;
//         this.weight = weight;
//     }
// }

// class Info implements Comparable<Info> {
//     int idx, dist;

//     Info() {}
//     Info(int idx, int dist) {
//         this.idx = idx;
//         this.dist = dist;
//     }

//     @Override
//     public int compareTo(Info o2) {
//         if(dist > o2.dist) {
//             return 1;
//         }else if(dist < o2.dist) {
//             return -1;
//         } else {
//             return 0;
//         }
//     }
// }