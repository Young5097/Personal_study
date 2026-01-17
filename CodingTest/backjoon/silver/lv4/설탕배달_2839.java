package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = -1;
        for (int i = n / 5; i >= 0; i--) {
            int remaining = n - i * 5;
            if (remaining % 3 == 0) {
                answer = i + remaining / 3;
                break;
            }
        }
        
        System.out.println(answer);

    }
}
