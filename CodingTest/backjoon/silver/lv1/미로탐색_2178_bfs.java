package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색_2178_bfs {
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String row = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = row.charAt(j-1) - '0';
            }
        }

        boolean[][] visited = new boolean[n+1][m+1];
        Queue<int[]> q = new LinkedList<>();
        visited[1][1] = true;
        q.offer(new int[] {1, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx > 0 && ny > 0 && nx <= n && ny <= m
                    && map[nx][ny] != 0 && !visited[nx][ny]
                ) {
                    map[nx][ny] = map[x][y] + 1;
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }

        System.out.println(map[n][m]);

    }
}
