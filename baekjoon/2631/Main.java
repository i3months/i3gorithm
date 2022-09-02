import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
            
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<N+1; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = -1;

        for(int k : dp){
            max = Math.max(max, k
            );
        }

        System.out.println(N - max);
        

    }
}