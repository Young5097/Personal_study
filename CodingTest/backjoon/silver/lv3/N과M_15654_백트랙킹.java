package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N과M_15654_백트랙킹 {
    static int N, M = 0;
    static StringBuilder sb;
    static int arr[];
    static boolean[] visited;
    static int[] N_arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        sb = new StringBuilder();
        visited = new boolean[N];
        arr = new int[M];

        N_arr = new int[N];
        String[] input2 = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            N_arr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(N_arr);

        backtracking(0);
        System.out.println(sb.toString());
    }

    public static void backtracking(int depth) {
        if (depth == M) {
            for (int i=0; i<M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = N_arr[i];
                backtracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
