// // 다익스트라
// import java.util.*;
// import java.io.*;
// import java.math.*;

// public class Main {			
// 	static int N, M, start;
// 	static int[] dist;
// 	static ArrayList<Edge>[] edge;	
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

// 		StringTokenizer st = new StringTokenizer(br.readLine());

// 		N = Integer.parseInt(st.nextToken());		
// 		M = Integer.parseInt(st.nextToken());
// 		start= Integer.parseInt(br.readLine());

// 		dist = new int[N+1];
// 		edge = new ArrayList[N+1];

// 		for(int i=1; i<N+1; i++){
// 			edge[i] = new ArrayList<>();			
// 		}
		
// 		for(int i=1; i<M+1; i++){
// 			st = new StringTokenizer(br.readLine());			
// 			int from = Integer.parseInt(st.nextToken());
// 			int to = Integer.parseInt(st.nextToken());
// 			int weight = Integer.parseInt(st.nextToken());

// 			edge[from].add(new Edge(to, weight));
// 		}

		
// 		dijkstra(start);

// 		for(int i=1; i<N+1; i++){
// 			if(dist[i] == Integer.MAX_VALUE){
// 				System.out.println("INF");
// 			}else{
// 				System.out.println(dist[i]);
// 			}
// 		}
		
// 	}

// 	static void dijkstra(int start){
// 		for(int i=1; i<N+1; i++){
// 			dist[i] = Integer.MAX_VALUE;			
// 		}

// 		PriorityQueue<Info> pq = new PriorityQueue<>();

// 		pq.add(new Info(start, 0));
// 		dist[start] = 0;

// 		while(!pq.isEmpty()){
// 			Info info = pq.poll();

// 			if(dist[info.idx] < info.dist){
// 				continue;
// 			}

// 			for(Edge e : edge[info.idx]){
// 				if(info.dist + e.weight >= dist[e.to]){
// 					continue;
// 				}
// 				dist[e.to] = info.dist + e.weight;
// 				pq.add(new Info(e.to, dist[e.to]));
// 			}
// 		}
// 	}
// }

// class Edge{
// 	int to, weight;
// 	Edge(int a, int b){
// 		to = a;
// 		weight = b;
// 	}
// }

// class Info implements Comparable<Info>{
// 	int idx, dist;

// 	Info(){}
// 	Info(int a, int b){
// 		idx = a;
// 		dist = b;
// 	}

// 	public int compareTo(Info o2){
// 		if(dist > o2.dist){
// 			return 1;
// 		}else{
// 			return -1;
// 		}
// 	}
// }