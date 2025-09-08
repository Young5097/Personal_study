package backjoon.gold.lv3;

/*
 * https://www.acmicpc.net/problem/15683
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 감시_15683_dfs {
    static int n, m = 0;
    static int[][] arr;
    static List<int[]> cctvs;
    static int result = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][][] cctvDirections = {
        {},
        {{0}, {1}, {2}, {3}}, // 1
        {{0, 1}, {2, 3}}, // 2
        {{1, 2}, {1, 3}, {0,2}, {0,3}}, // 3
        {{0, 2, 3}, {1, 2, 3}, {2, 0, 1}, {3, 0, 1}}, // 4
        {{0, 1, 2, 3}} // 5
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        arr = new int[n][m];
        cctvs = new ArrayList<>(); // cctv Queue

        for (int i=0; i<n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(input2[j]);
                if (arr[i][j] > 0 && arr[i][j] < 6) {
                    cctvs.add(new int[] {i, j, arr[i][j]});
                }
            }
        }

        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int idx) {
        if (idx == cctvs.size()) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) {
                        count++;
                    }
                }
            }
            result = Math.min(count, result);
            return;
        }

        int[] cctv = cctvs.get(idx);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];

        for (int[] directions : cctvDirections[type]) {
            int[][] backup = copyArr(arr);

            for (int dir : directions) {
                int nx = x;
                int ny = y;

                while(true) {
                    nx += dx[dir];
                    ny += dy[dir];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 6) {
                        break;
                    }

                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = -1;
                    }
                }
            }

            dfs(idx+1);
            arr = backup;
        }
    }

    public static int[][] copyArr(int [][] arr) {
        int[][] backup = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                backup[i][j] = arr[i][j];
            }
        }
        return backup;
    }
}
