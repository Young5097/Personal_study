package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz_1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();


        int nxt = 0;
        if (isDigit(s1)) { 
            nxt = Integer.parseInt(s1) + 3;
        } else if (isDigit(s2)) {
            nxt = Integer.parseInt(s2) + 2;
        } else if (isDigit(s3)) {
            nxt = Integer.parseInt(s3) + 1;
        }

        String result = getFizzBuzz(nxt);
        System.out.println(result);
    }

    public static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getFizzBuzz(int n) {
        if (n % 15 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }
}
