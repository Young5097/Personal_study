package backjoon.silver.lv1;

import java.io.*;
import java.util.*;

public class 단지번호붙이기_2667 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[N][N];
        List<Integer> aptCount = new ArrayList<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;

                Queue<int[]> q = new LinkedList<>();
                int count = 0;

                q.offer(new int[] {i, j});
                count++;
                visited[i][j] = true;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int k=0; k<4; k++) {
                        int nx  = cur[0] + dx[k];
                        int ny  = cur[1] + dy[k];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (visited[nx][ny] || map[nx][ny] == 0) continue;

                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                        count++;
                    }
                }
                aptCount.add(count);
            }
        }

        Collections.sort(aptCount);
        StringBuilder sb = new StringBuilder();
        sb.append(aptCount.size()).append("\n");
        for (int count : aptCount) {
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
