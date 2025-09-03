package backjoon.gold.lv4;

/*
 * https://www.acmicpc.net/problem/9663
 */

import java.util.Scanner;

public class NQueen_9663_백트랙킹 {

    // 여기서 한점의 대각선들의 점은 x+y or x-y가 같음
    static boolean[] possible1 = new boolean[16]; // 열
    static boolean[] possible2 = new boolean[40]; // / 대각선 (4,0) (3,1) (2,2) -> 4 
    static boolean[] possible3 = new boolean[40]; // \ 대각선 (0,0) (1,1) (2,2) -> 0
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        backtracking(n, 0);
        System.out.println(count);
    }

    public static void backtracking(int n, int row) {
        if (n == row) {
            count++;
            return;
        }

        for (int i=0; i<n; i++) {
            if (!possible1[i] && !possible2[row+i] && !possible3[row-i + n-1]) {
                possible1[i] = true;
                possible2[row+i] = true;
                possible3[row-i + n-1] = true;
                backtracking(n, row + 1);
                possible1[i] = false;
                possible2[row+i] = false;
                possible3[row-i + n-1] = false;
            }
        }
    }
}