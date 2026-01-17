package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구간합구하기4_11659_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N, M 입력
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        
        String[] nums = br.readLine().split(" ");
        int[] dp = new int[N+1];
        for (int i=1; i<=N; i++) {
            dp[i] = Integer.parseInt(nums[i-1]) + dp[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            String[] str = br.readLine().split(" ");
            int st = Integer.parseInt(str[0]);
            int en = Integer.parseInt(str[1]);
            sb.append(dp[en]- dp[st-1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
