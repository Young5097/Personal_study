package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 0; // n번째 종말수를 찾기위함
        
        while (count < n) {
            if (isDoomsDayNum(num)) {
                count++;
            }
            
            if (count == n) {
                System.out.println(num);
                break;
            }
            
            num++;
        }
    }

    public static boolean isDoomsDayNum(int n) {
        String s = String.valueOf(n);
        int count6 = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '6') {
                count6++;
                if (count6 == 3) {
                    return true;
                }
            } else {
                count6 = 0;
            }
        }
        return false;
    }
}
