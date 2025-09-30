package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기_1654_parameticSearch {
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

            int count = 0;
            for (int cable : cables) {
                count += cable/mid;
            }

            if (N <= count) { // 더 크게 자르거나 맞는 상황
                answer = mid;
                st = mid+1;
            } else { // 부족하므로 더 작게 잘라야하는 상황
                en = mid-1;
            }
        }

        System.out.println(answer);
    }
}