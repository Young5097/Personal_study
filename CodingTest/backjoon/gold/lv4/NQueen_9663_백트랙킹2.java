package backjoon.gold.lv4;

import java.util.Scanner;

public class NQueen_9663_백트랙킹2 {
    // idx = row, arr[idx] = col로 풀이 
    static int N;
    static int[] arr;
    static int cnt = 0; // 퀸을 배치하는 경우의 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        backtracking(0);
        System.out.println(cnt);
    }

    public static void backtracking(int row) {
        if (row == N) {
            cnt++;
            return; 
        }

        for (int i=0; i<N; i++) {
            arr[row] = i;
            if (check(row)) {
                backtracking(row+1);
            }
        }
    }

    public static boolean check(int row) {
        for (int i=0; i<row; i++) { // row-1 이후는 아직 퀸이 배치되지 않음
            if (arr[i] == arr[row]) return false;
            if (Math.abs(i - row) == Math.abs(arr[i] - arr[row])) return false;
        }
        return true;
    }
}