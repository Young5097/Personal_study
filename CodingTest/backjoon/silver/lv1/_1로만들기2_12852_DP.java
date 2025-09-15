package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기2_12852_DP {
    static int[] dp = new int[1000001]; 
    static int[] pre = new int[1000001]; // 이전에 어디서 왔는지 기록
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp[1] = 0;
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;
            pre[i] = i-1;
            if (i%3==0 && dp[i] > dp[i/3]+1) {
                dp[i] = dp[i/3]+1;
                pre[i] = i/3; 
            }
            if (i%2==0 && dp[i] > dp[i/2]+1) {
                dp[i] = dp[i/2]+1; 
                pre[i] = i/2; 
            }
        }

        System.out.println(dp[N]);

        StringBuilder sb = new StringBuilder();
        int current = N;
        while (current != 0) {
            sb.append(current).append(" ");
            current = pre[current];
        }
        System.out.println(sb.toString().trim());
    }
}
