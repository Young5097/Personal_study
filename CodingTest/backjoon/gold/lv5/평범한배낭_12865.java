package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫째 줄: N(물품의 수)과 K(배낭이 버틸 수 있는 최대 무게) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 물건의 무게와 가치를 저장할 배열
        int[] weight = new int[N + 1];  // 1-indexed 사용
        int[] value = new int[N + 1];
        
        // 두 번째 줄부터: N개의 물건 정보 입력 (무게 W, 가치 V)
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken()); 
            value[i] = Integer.parseInt(st.nextToken());   
        }
        
        int[][] dp = new int[N+1][K+1]; 
        for (int i=1; i<=N; i++) {
            for (int w=1; w<=K; w++) {
                if (weight[i] > w) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    dp[i][w] = Math.max(
                        dp[i-1][w], 
                        dp[i-1][w-weight[i]] + value[i]
                    );
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
