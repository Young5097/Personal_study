package backjoon.gold.lv2;

import java.util.Scanner;

/*
 * 배열의 각 행은 행번호*N이 된다.
 * 1 2 3 -> 1i => 3 
 * 2 4 6 -> 2i => 2 
 * 3 6 9 -> 3i => 1
 * => 1,2,2,3,3,4,6,6,8 
 * => 따라서 B[K]는 K를 넘을 수 없음
 */
public class K번째수_1300 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        long start = 1;
        long end = K;
        long answer = 0;
        
        while (start<=end) {
            long mid = (start+end)/2;
            int cnt = 0;
            for (int i=1; i<=N; i++) {
                cnt += Math.min(mid/i, N);
            }
            if (cnt < K) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid -1;
            }
        }
        System.out.println(answer);
    }
}

