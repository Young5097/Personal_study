package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7576 {
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]); // 열
        int n = Integer.parseInt(input[1]); // 행

        int[][] boxs = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                int num = Integer.parseInt(str[j]);
                boxs[i][j] = num;
                if (num == 1) {
                    visited[i][j] = true;
                    q.add(new int[] {i, j});
                } 
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m 
                    && !visited[nx][ny] && boxs[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    boxs[nx][ny] = boxs[x][y] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }

        int answer = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (boxs[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, boxs[i][j]);
            }
        }

        System.out.println(answer - 1);
    }
}