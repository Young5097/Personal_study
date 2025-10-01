package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(A);
        int answer = Integer.MAX_VALUE;

        // 1. 이분탐색 풀이
        for (int i=0; i<N; i++) {
            int target = A[i] + M;
            int st = i;
            int en = N-1;

            while (st <= en) {
                int mid = (st + en) / 2;
                if (A[mid] >= target) {
                    answer = Math.min(answer, A[mid] - A[i]);
                    en = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
        }

        // 2. 투포인터
        int st = 0;
        int en = 1;
        while (en < N) {
            int diff = A[en] - A[st];
            if (diff >= M) {
                answer = Math.min(answer, diff);
                st++;
            } else {
                en++;
            }

            if (st == en) en++;
        }


        System.out.println(answer);
    }
}
