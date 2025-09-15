package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구간합구하기4_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N, M 입력
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        
        // N개의 수 입력
        String[] nums = br.readLine().split(" ");
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.parseInt(nums[i - 1]) + dp[i-1];
        }
        
        StringBuilder sb = new StringBuilder();
        // M개의 쿼리 입력
        for (int k = 0; k < M; k++) {
            String[] query = br.readLine().split(" ");
            int i = Integer.parseInt(query[0]);
            int j = Integer.parseInt(query[1]);
            
            sb.append(dp[j] - dp[i-1]).append("\n");
            // 구간 [i, j] 처리
        }
        
        System.out.println(sb.toString());
    }
}
