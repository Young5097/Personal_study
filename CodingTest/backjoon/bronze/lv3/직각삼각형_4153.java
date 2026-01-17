package backjoon.bronze.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 직각삼각형_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String[] arr = br.readLine().split(" ");
            int[] num_arr = new int[arr.length];
            for (int i=0; i<arr.length; i++) {
                num_arr[i] = Integer.parseInt(arr[i]);
            }
            
            Arrays.sort(num_arr);
            int a = num_arr[0];
            int b = num_arr[1];
            int c = num_arr[2];
            
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            if (a*a + b*b == c*c) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
