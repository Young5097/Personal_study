package backjoon.silver.lv3;

/*
 * https://www.acmicpc.net/problem/15649
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N과M_15652_백트랙킹 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[M];
        StringBuilder sb =new StringBuilder();
        backtracking(N, M, 0, arr, sb);
        System.out.println(sb.toString());

    }

    public static void backtracking(int N, int M, int depth, int[] arr, StringBuilder sb) {
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (depth > 0 && arr[depth-1] > i) {
                continue;
            }
            arr[depth] = i; 
            backtracking(N, M, depth+1, arr, sb);
        }
    }
}
