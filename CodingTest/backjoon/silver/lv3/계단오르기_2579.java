package backjoon.silver.lv3;

import java.io.*;

public class 계단오르기_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        int[] scores = new int[n + 1]; 
        scores[1] = stairs[1];
        scores[2] = stairs[1]+stairs[2];

        for (int i=3; i<=n; i++) {
            scores[i] = Math.max(scores[i-2] + stairs[i], scores[i-3] + scores[i-1] + stairs[i]);
        }

        System.out.println(scores[n]);
    }
}
