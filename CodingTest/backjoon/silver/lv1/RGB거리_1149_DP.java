package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 집의 수 N 입력
        int n = Integer.parseInt(br.readLine());
        
        // N개의 집에 대한 RGB 비용을 저장할 2차원 배열
        int[][] houses = new int[n][3];
        
        // 각 집(i)의 RGB 비용 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            houses[i][0] = Integer.parseInt(st.nextToken()); // 빨강
            houses[i][1] = Integer.parseInt(st.nextToken()); // 초록
            houses[i][2] = Integer.parseInt(st.nextToken()); // 파랑
        }

        int[][] dp = new int[n][3];
        // 첫번째 집에 3가지 색을 칠하는 경우
        dp[0][0] = houses[0][0];
        dp[0][1] = houses[0][1];
        dp[0][2] = houses[0][2];

        // 두번째 집부터 N번째 집까지 가면서 이전 집에 칠한 색과 다른 두가지 색 중에 최솟값을 칠함
        for (int i=1; i<n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + houses[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + houses[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + houses[i][2];
        }

        int result = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(result);
    }
}
