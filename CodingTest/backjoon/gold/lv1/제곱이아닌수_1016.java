package backjoon.gold.lv1;

import java.util.Scanner;

public class 제곱이아닌수_1016 {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        
        boolean[] chk_arr = new boolean[(int) (max-min+1)];

        for (long i=2; i<Math.sqrt(max); i++) {
            long pow = i*i;

            // min보다 큰 pow의 배수 중 최솟값 찾기
            // min/pow는 min보다 작은 pow의 배수들의 갯수 -> 여기에 pow를 곱하면 그 중 최댓값
            long st = (min / pow) * pow;
            // st는 min보다 작거나 같은값이 나옴. 따라서 작으면 +pow를 해줌
            if (st < min) {
                st += pow;
            }
            for (long j=st; j<=max; j+=pow) {
                chk_arr[(int) (j-min)] = true;
            }
        }

        int count = 0;
        for (boolean chk : chk_arr) {
            if (!chk) count++;
        }
        System.out.println(count);
    }  
}
