package backjoon.gold.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 불_4179_bfs {

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        
        Character[][] maps = new Character[row][col];
        for (int i=0; i<row; i++) {
            String rows = br.readLine();
            for (int j=0; j<col; j++) {
                maps[i][j] = rows.charAt(j);
            }
        }

        int[][] fire_map = new int[row][col];
        int[][] j_map = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(fire_map[i], -1);
            Arrays.fill(j_map[i], -1);
        }

        bfs_fire(maps, fire_map, row, col);
        int result = bfs_j(maps, fire_map, j_map, row, col);
        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    public static void bfs_fire(Character[][] maps, int[][] fire_map, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maps[i][j] == 'F') {
                    fire_map[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (fire_map[nx][ny] == -1 && maps[nx][ny] != '#') {
                        fire_map[nx][ny] = fire_map[x][y] + 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }

    public static int bfs_j(Character[][] maps, int[][] fire_map, int[][] j_map, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maps[i][j] == 'J') {
                    j_map[i][j] = 0;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == 0 || y == 0 || x == n-1 || y == m-1) {
                return j_map[x][y] + 1;
            }

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (j_map[nx][ny] == -1 && maps[nx][ny] != '#') {
                        if (fire_map[nx][ny] == -1 || j_map[x][y] + 1 < fire_map[nx][ny] ) {
                            j_map[nx][ny] = j_map[x][y] + 1;
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
