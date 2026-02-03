package backjoon.gold.lv5;

import java.io.*;
import java.util.*;

public class 적록색약_10026 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        boolean[][] visited1 = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];

        int answer1 = 0;
        int answer2 = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited1[i][j]) {
                    bfs(map, visited1, i, j, n, false);
                    answer1++;
                }

                if (!visited2[i][j]) {
                    bfs(map, visited2, i, j, n, true);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }


    public static void bfs(char[][] map, boolean[][] visited, int x, int y, int n, boolean flag) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        char curColor = map[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    char nxtColor = map[nx][ny];
                    boolean same = false;
                    if (flag) { // 색약있는 사람
                        if ((curColor == nxtColor) ||
                            (curColor == 'R'&& nxtColor == 'G') ||
                            (curColor == 'G'&& nxtColor == 'R')
                        ) {
                            same = true;
                        }
                    } else {
                        if (curColor == nxtColor) {
                            same = true;
                        }
                    }

                    if (same) {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}