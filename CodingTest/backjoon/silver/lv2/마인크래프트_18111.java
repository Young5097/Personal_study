package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 마인크래프트_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int b = Integer.parseInt(st[2]);

        int[][] maps = new int[n][m];
        for (int i=0; i<n; i++) {
            String [] st2 = br.readLine().split(" ");
            for (int j=0; j<m; j++) {
                maps[i][j] = Integer.parseInt(st2[j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHei = 0;

        for (int h=0; h<=256; h++) {
            int need = 0; // 올리기
            int remove = 0; // 캐기

            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    int curH = maps[i][j];
                    if (curH > h) {
                        remove += curH - h;
                    } else if (curH < h) {
                        need += h - curH;
                    }
                }
            }
 
            if (remove + b >= need) {
                int time = need + remove*2;

                if (minTime > time || (minTime == time && maxHei < h)) {
                    minTime = time;
                    maxHei = h;
                }
            }
        }

        System.out.println(minTime + " " + maxHei);
    }    
}
