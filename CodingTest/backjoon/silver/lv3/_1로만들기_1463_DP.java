package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 테이블 정의 + 점화식 찾기
// X에서 1을 만드는게 아니라 1 -> X로 만들어가기

public class _1로만들기_1463_DP {
    static int[] dp_arr = new int[1000001]; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        dp_arr[1] = 0;
        for (int i=2; i<=X; i++) {
            dp_arr[i] = dp_arr[i-1] + 1;
            if (i%3 == 0) dp_arr[i] = Math.min(dp_arr[i], dp_arr[i/3]+1); 
            if (i%2 == 0) dp_arr[i] = Math.min(dp_arr[i], dp_arr[i/2]+1); 
            System.out.println(dp_arr[i]);
        }

        System.out.println(dp_arr[X]);
    }
}
