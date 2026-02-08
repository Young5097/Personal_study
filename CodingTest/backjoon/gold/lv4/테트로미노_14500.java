package backjoon.gold.lv4;

import java.io.*;
import java.util.*;

public class 테트로미노_14500 {
    static int n;
    static int m;
    static int[][] maps;
    static boolean[][] visited;

    static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
    
        maps = new int[n][m];
        visited = new boolean[n][m];
        for (int i=0; i<n; i++) {
            String[] str2= br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                maps[i][j] = Integer.parseInt(str2[j]);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                visited[i][j] = true;
                dfs(i, j, maps[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int x, int y, int total, int count) {
        if (count == 4) {
            result = Math.max(total, result);
            return;
        }

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (!visited[nx][ny]) {
                if (count == 2) { // ㅗ모양을 만들때 1->2에서 3은 갔다치고 maps[nx][ny]를 더해만주고, 다시 2에서 위 or 아래로 이동
                    visited[nx][ny] = true;
                    dfs(x, y, total + maps[nx][ny], count+1);
                    visited[nx][ny] = false;
                }
                
                visited[nx][ny] = true;
                dfs(nx, ny, total + maps[nx][ny], count + 1);
                visited[nx][ny] = false;

            }
        }
    }
}
