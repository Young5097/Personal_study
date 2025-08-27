package backjoon.gold.lv5;

/*
 * https://www.acmicpc.net/problem/7569
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7568_bfs {
    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]); // 열
        int n = Integer.parseInt(input[1]); // 행
        int o = Integer.parseInt(input[2]); // 높이

        int[][][] boxs = new int[o][n][m];

        for (int h = 0; h < o; h++) {
            for (int r = 0; r < n; r++) {
                String row = br.readLine();
                String[] parts = row.split(" ");
                for (int c = 0; c < m; c++) {
                    boxs[h][r][c] = Integer.parseInt(parts[c]);
                }
            }
        }

        boolean[][][] visited = new boolean[o][n][m];
        int result = bfs(boxs, visited, o, n, m);

        System.out.println(result);
    }

    public static int bfs(int[][][] boxs, boolean[][][] visited, int o, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        // 익은 토마토를 모두 큐에 넣기
        for (int h = 0; h < o; h++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (boxs[h][r][c] == 1 && !visited[h][r][c]) {
                        visited[h][r][c] = true;
                        queue.offer(new int[] { h, r, c });
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int ch = curr[0];
            int cr = curr[1];
            int cc = curr[2];

            for (int i = 0; i < 6; i++) {
                int nh = ch + dz[i];
                int nr = cr + dy[i];
                int nc = cc + dx[i];

                if (nh >= 0 && nr >= 0 && nc >= 0 && nh < o && nr < n && nc < m) {
                    if (!visited[nh][nr][nc] && boxs[nh][nr][nc] == 0) {
                        boxs[nh][nr][nc] = boxs[ch][cr][cc] + 1;
                        visited[nh][nr][nc] = true;
                        queue.offer(new int[] { nh, nr, nc });
                    }
                }
            }
        }

        int maxDay = 0;
        boolean hasZero = false;
        for (int h = 0; h < o; h++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (boxs[h][r][c] == 0) {
                        hasZero = true;
                    }
                    maxDay = Math.max(maxDay, boxs[h][r][c]);
                }
            }
        }

        if (hasZero) {
            return -1;
        } else {
            return maxDay - 1;
        }
    }
}