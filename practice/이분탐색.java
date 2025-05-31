// // 이분탐색
// import java.util.*;
// import java.io.*;

// public class Main {

// 	static int N;
// 	static int K;
	
// 	static int LAN[];

// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// 		StringTokenizer st = new StringTokenizer(br.readLine());

// 		K = Integer.parseInt(st.nextToken());
// 		N = Integer.parseInt(st.nextToken());

// 		LAN = new int[K + 1];		

// 		for (int i = 1; i < K + 1; i++) {
// 			LAN[i] = Integer.parseInt(br.readLine());
// 		}

// 		System.out.println(solve());


// 	}

// 	static long solve(){
// 		long L = 1; 
// 		long R = Integer.MAX_VALUE;
// 		long ans = 0;

// 		while(L <= R){
// 			long mid = (L + R) / 2;
// 			if(cut_check(mid)){
// 				ans = mid;
// 				L = mid + 1;
// 			}else{
// 				R = mid - 1;
// 			}
// 		}

// 		return ans;

// 	}

// 	static boolean cut_check(long cut){
// 		long sum = 0;
// 		for(int i = 1; i< K + 1; i++){
// 			sum = sum + LAN[i] / cut;
// 		}

// 		if(sum >= N){
// 			return true;
// 		}else{
// 			return false;
// 		}

// 	}


// }