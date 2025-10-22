package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 표의 크기
        int M = Integer.parseInt(st.nextToken());  // 합을 구해야 하는 횟수

        // N x N 배열 입력
        int[][] arr = new int[N + 1][N + 1];  // 1-indexed
        int[][] s = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + arr[i][j];
            }
        }
        
        // M개의 쿼리 입력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            int result = s[x2][y2] - (s[x1-1][y2]  + s[x2][y1-1]) + s[x1-1][y1-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
