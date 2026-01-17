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

        List<Integer> houseGroupCount = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int count = 1;
                    visited[i][j] = true;
                    
                    Stack<int[]> stack = new Stack<>();
                    stack.add(new int[] {i, j});
                    
                    while (!stack.isEmpty()) {
                        int[] cur = stack.pop();
                        int x = cur[0];
                        int y = cur[1];
                        
                        for (int k=0; k<4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && ny >= 0 && nx < N && ny < N
                                && !visited[nx][ny] && map[nx][ny] == 1
                            ) {
                                count += 1;
                                visited[nx][ny] = true;
                                stack.add(new int[] {nx, ny});
                            }
                        }
                    }
                    houseGroupCount.add(count);
                }    
            }
        }

        Collections.sort(houseGroupCount);
        System.out.println(houseGroupCount.size());
        for (int n : houseGroupCount) {
            System.out.println(n);
        }
    }
}
