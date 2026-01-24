package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 헌내기는친구가필_21736 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        char[][] maps = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] start = new int[2];
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<m; j++) {
                maps[i][j] = line.charAt(j);
                if (maps[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                } 
            }
        }
        
        Stack<int[]> stack = new Stack<>();
        stack.add(start);

        int answer = 0;
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int x = cur[0];
            int y = cur[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m 
                    && !visited[nx][ny] && maps[nx][ny] != 'X'
                ) {
                    if (maps[nx][ny] == 'P') {
                        answer += 1;
                    }
                    visited[nx][ny] = true;
                    stack.add(new int[] {nx, ny});
                }
            }
        }

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }    
}
