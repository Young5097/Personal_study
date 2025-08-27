package backjoon.silver.lv1;

/*
 * https://www.acmicpc.net/problem/1926
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 그림_1926_bfs {

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] canvas = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(row[j]);
            }
        }

        boolean[][] visited = new boolean[n][m];

        int count = 0;
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canvas[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(canvas, visited, i, j, n, m);
                    count++;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    public static int dfs(int[][] canvas, boolean[][] visited, int x, int y, int n, int m) {
        visited[x][y] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (canvas[nx][ny] == 1 && !visited[nx][ny]) {
                    size += bfs(canvas, visited, nx, ny, n, m);
                }
            }
        }

        return size;
    }

    public static int bfs(int[][] canvas, boolean[][] visited, int x, int y, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        visited[x][y] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0];
            int cy = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (canvas[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] { nx, ny });
                        size++;
                    }
                }
            }
        }
        return size;
    }
}
