package backjoon.gold.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기_17136 {
    static int[][] map = new int[10][10];
    static int[] paperCount = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        backtracking(0 ,0,0);

        System.out.println(result==Integer.MAX_VALUE?-1:result);
    }

    static void backtracking(int x, int y, int count) {
        if (count >= result) return;

        if (y==10) {
            backtracking(x+1, 0, count);
            return;
        }
        if (x==10) {
            result = Math.min(result, count);
            return;
        }

        if (map[x][y] == 1) {
            for (int size=5; size>0; size--) {
                if (paperCount[size] > 0 && isAttach(x, y, size)) {
                    attach(x, y, size, 0);
                    paperCount[size]--;
                    backtracking(x, y+1, count+1);
                    attach(x, y, size, 1);
                    paperCount[size]++;
                }
            }
        } else {
            backtracking(x, y+1, count);
        }
    }

    static boolean isAttach(int x, int y, int size) {
        if (x+size>10 || y+size>10) return false;
        
        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (map[i][j] == 0) return false;
            }
        }

        return true;
    }

    static void attach(int x, int y, int size, int state) {
        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                map[i][j] = state;
            }
        }
    }
}
