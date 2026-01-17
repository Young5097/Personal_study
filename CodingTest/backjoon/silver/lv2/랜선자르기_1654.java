package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // K, N 입력
        StringTokenizer stoken = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(stoken.nextToken());
        int N = Integer.parseInt(stoken.nextToken());
        
        // K개의 랜선 길이 입력
        int[] cables = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, cables[i]);
        }

        long st = 1;
        long en = max;
        long answer = 0;

        while (st <= en) {
            long mid = (st+en)/2;

            int count=0;
            for (int cable : cables) {
                count += cable/mid;
            }

            if (count < N) { // 자른 전선이 부족한 경우 -> 더 짧게게 짤라야함
                en = mid-1;
            } else if (count >= N) { // 자른 전선이 더 많은 경우 -> 더 길게 짤라야함
                st = mid+1;
                answer = mid; // 자른 전선이 부족하면 X. 또한 최댓값이 되어야하기 때문에 
            } 
        }

        System.out.println(answer);
    }
}