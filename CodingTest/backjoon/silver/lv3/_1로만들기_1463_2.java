package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기_1463_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X+1];
        dp[1] = 0;
        for (int i=2; i<=X; i++) {
            dp[i] = dp[i-1] + 1;
            if (i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            if (i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
        }


        System.out.println(dp[X]);
    }
}
