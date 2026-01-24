package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색종이만들기_2630 {
    
    static int cntWhite = 0;
    static int cntBlue = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] maps = new int[n][n];

        for (int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                maps[i][j] = Integer.parseInt(str[j]);
            }
        }

        divide(maps,0, 0, n);

        System.out.println(cntWhite);
        System.out.println(cntBlue);
    }

    public static void divide(int[][] maps, int row, int col, int len) {
        if (isPaper(maps, row, col, len)) {
            if (maps[row][col] == 1) {
                cntBlue += 1;
            } else {
                cntWhite += 1;
            }
            return;
        }

        int newLen = len/2;
        divide(maps, row, col, newLen);
        divide(maps, row + newLen, col, newLen);
        divide(maps, row, col + newLen, newLen);
        divide(maps, row + newLen, col + newLen, newLen);
        divide(maps, row + newLen, col + newLen, newLen);
    }

    public static boolean isPaper(int[][] maps, int row, int col, int len) {
        int color = maps[row][col];

        for (int i=row; i<len+row; i++) {
            for (int j=col; j<len+col; j++) {
                if (maps[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}