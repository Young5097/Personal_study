package backjoon.silver.lv1;

import java.io.BufferedReader;       
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 쉬운최단거리_14940 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[][] maps = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] start = new int[2];
        for (int i=0; i<n; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                maps[i][j] = Integer.parseInt(str2[j]);
                if (Integer.parseInt(str2[j]) == 2) {
                    visited[i][j] = true;
                    maps[i][j] = 0;
                    start = new int[] {i, j};
                }
            }   
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m 
                    && !visited[nx][ny] && maps[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && maps[i][j] != 0) {
                    maps[i][j] = -1;
                }
                sb.append(maps[i][j]).append(" ");
            }   
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
