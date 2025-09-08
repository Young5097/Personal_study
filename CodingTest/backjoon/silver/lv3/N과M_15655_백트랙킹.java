package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 중복되는 조합이 없어여함 -> 조합

public class N과M_15655_백트랙킹 {
    static int N, M = 0;
    static StringBuilder sb;
    static int arr[];
    static int[] N_arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        sb = new StringBuilder();

        arr = new int[M];
        N_arr = new int[N];
        String[] input2 = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            N_arr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(N_arr);

        backtracking(0, 0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int depth, int start) {
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<N; i++) { // 자기보다 큰 것만 선택
            arr[depth] = N_arr[i];
            backtracking(depth+1, i+1);
        }
    }
}
