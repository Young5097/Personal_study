/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */

public class 멀리뛰기 {
    public long solution(int n) {
        if (n <= 2)
            return n;

        long[] dp = new long[n + 1]; // 배열은 0부터 시작하므로 n+1 크기로 선언(0은 안씀)
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}
