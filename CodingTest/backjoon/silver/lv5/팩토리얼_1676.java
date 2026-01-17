package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 뒤에가 0이 오는 경우는 2*5 
// 따라서 2랑 5의 갯수를 세고 둘이 같은 count만큼 0이 온다
// 소인수분해 했을때 2는 5보다 항상 많기 때문에 5의 갯수가 답임

public class 팩토리얼_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=1; i<=n; i++) {
            int num = i;
            while (num%5 == 0) {
                num /= 5;
                count++;
            }
        }

        System.out.println(count);
    }
}

