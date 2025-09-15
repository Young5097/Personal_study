package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 보물_1026_그리디 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // A 배열 입력
        String[] aInput = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(aInput[i]);
        }
        
        // B 배열 입력
        String[] bInput = br.readLine().split(" ");
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(bInput[i]);
        }
        
        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;
        for (int i=0; i<N; i++) {
            result +=  A[i] * B[N-i-1];
        }
        System.out.println(result);
    }
}
