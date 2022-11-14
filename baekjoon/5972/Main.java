import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static int INF = 987654321;

	static int N, M, start;
	static int[] dist;
	static ArrayList<Edge>[] list;	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());	

		dist = new int[N+1];
		list = new ArrayList[N+1];

		for(int i=1; i<N+1; i++){
			list[i] = new ArrayList<>();			
		}
		
		for(int i=1; i<M+1; i++){
			st = new StringTokenizer(br.readLine());	

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}

		
		dijkstra(1);

		System.out.println(dist[N]);

		
		
	}

	static void dijkstra(int start){

		for(int i=1; i<N+1; i++){
			dist[i] = INF;
		}

        dist[start] = 0;

		PriorityQueue<Info> pq = new PriorityQueue<>();

		pq.add(new Info(start, 0));	

		while(!pq.isEmpty()){
			Info info = pq.poll();

			if(dist[info.idx] < info.dist){
				continue; // 최단거리가 아니면 바로 컷
			}

			for(Edge e : list[info.idx]){
				if(dist[info.idx] + e.weight >= dist[e.to])	continue;				

				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}
}

class Edge{
	int to, weight;

	Edge(int a, int b){
		to = a;
		weight = b;
	}

    @Override
    public boolean equals(Object o2){
        Edge o3 = (Edge)o2;

        if(to == o3.to && weight == o3.weight){
            return true;
        }
        return false;
    }
}

class Info implements Comparable<Info>{
	int idx, dist;

	Info(){}    
	Info(int a, int b){
		idx = a;
		dist = b;
	}

    @Override
	public int compareTo(Info o2){
		if(dist > o2.dist){
			return 1;
		}else if(dist < o2.dist){
			return -1;
		}else{
            return 0;
        }
	}
}