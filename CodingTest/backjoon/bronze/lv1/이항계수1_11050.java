package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이항계수1_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        long result = factorial(n) / (factorial(k) * factorial(n-k));
        System.out.println(result); 
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i=2; i<=n; i++) {
            result *= i;
        }
        return result;
    }

    public static void dp(int n, int k) {
        int[][] dp = new int[n+1][k+1];

        for (int i=0; i<=n; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=Math.min(i, k); j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}
 