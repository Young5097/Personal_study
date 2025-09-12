package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열합치기_11728_정렬 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        String[] arrA_input = br.readLine().split(" ");
        int[] arrA = new int[N];
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(arrA_input[i]);
        }

        String[] arrB_input = br.readLine().split(" ");
        int[] arrB = new int[M];
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(arrB_input[i]);
        }

        mergeSorted(arrA, arrB);
    }

    public static void mergeSorted(int[] arrA, int[] arrB) {
        int[] mergeArr = new int[N + M];
        int aIdx =0, bIdx =0;

        for (int i=0; i<N+M; i++) {
            if (aIdx == N) {
                mergeArr[i] = arrB[bIdx++];
            } else if (bIdx == M) {
                mergeArr[i] = arrA[aIdx++];
            } else if (arrA[aIdx] <= arrB[bIdx]) {
                mergeArr[i] = arrA[aIdx++];
            } else if (arrB[bIdx] <= arrA[aIdx]) {
                mergeArr[i] = arrB[bIdx++];
            } 
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mergeArr.length; i++) {
            sb.append(mergeArr[i]).append(" ");
        }
        System.out.print(sb.toString());
    }
}
