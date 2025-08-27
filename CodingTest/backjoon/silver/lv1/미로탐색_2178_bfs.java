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

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        boolean[][] visited = new boolean[n][m];
        bfs(map, visited, 0, 0, n, m);

        System.out.println(map[n - 1][m - 1]);

    }

    public static void bfs(int[][] map, boolean[][] visited, int x, int y, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int new_x = pos[0] + dx[i];
                int new_y = pos[1] + dy[i];

                if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
                    if (map[new_x][new_y] != 0 && !visited[new_x][new_y]) {
                        map[new_x][new_y] = map[pos[0]][pos[1]] + 1;
                        visited[new_x][new_y] = true;
                        queue.offer(new int[] { new_x, new_y });
                    }
                }
            }
        }
    }
}
