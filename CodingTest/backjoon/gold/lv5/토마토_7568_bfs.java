package backjoon.gold.lv5;

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
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<o; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<m; k++) {
                    if (boxs[i][j][k] == 1 && !visited[i][j][k]) {
                        visited[i][j][k] = true;
                        q.add(new int[] {i, j, k});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curH = cur[0];
            int curX = cur[1];
            int curY = cur[2];
        
            for (int i=0; i<6; i++) {
                int nxtH = curH + dx[i];
                int nxtX = curX + dy[i];
                int nxtY = curY + dz[i];

                if (nxtH < 0 || nxtX < 0 || nxtY < 0
                    || nxtH >= o || nxtX >= n || nxtY >= m
                ) continue;

                if (!visited[nxtH][nxtX][nxtY] && boxs[nxtH][nxtX][nxtY] == 0) {
                    visited[nxtH][nxtX][nxtY] = true;
                    boxs[nxtH][nxtX][nxtY] = boxs[curH][curX][curY] + 1; 
                    q.add(new int[] {nxtH, nxtX, nxtY});
                }
            }
        }

        int answer = 0;
        for (int i=0; i<o; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<m; k++) {
                    if (boxs[i][j][k] == 0) {
                        return -1;
                    }
                    answer = Math.max(answer, boxs[i][j][k]);
                }
            }
        }

        return answer - 1;
    }
}