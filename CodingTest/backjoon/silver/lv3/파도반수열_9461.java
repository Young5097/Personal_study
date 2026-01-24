package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[101];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            
            for (int i=4; i<=n; i++) {
                dp[i] = dp[i-2] + dp[i-3];
            }

            System.out.println(dp[n]);
        }
    }
}


