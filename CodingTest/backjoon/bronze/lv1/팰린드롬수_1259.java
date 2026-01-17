package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }

            char[] arr = s.toCharArray();
            boolean isP = true;
            for (int i=0; i<arr.length/2; i++) {
                int a = arr[i] - '0';
                int b = arr[arr.length-i-1] - '0';
                if (a != b) {
                    isP = false;
                    System.out.println("no");
                    break;
                }
            }

            if (isP) System.out.println("yes");
        }
    }
}
