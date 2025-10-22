package backjoon.silver.lv5;

import java.io.*;

public class 수들의합_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int sum = 1;
        int st = 1;
        int en = 1;
        while (en != N) {
            if (sum > N) {
                sum -= st;
                st++;
            } else if (sum < N) {
                en++;
                sum += en;
            } else {
                count++;
                en++;
                sum += en;
                // sum -= st; st++; 해도 비슷하게 동작함
            }
        }

        System.out.println(count);
    }
}
