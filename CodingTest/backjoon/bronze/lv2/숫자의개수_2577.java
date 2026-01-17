package backjoon.bronze.lv2;

import java.util.Scanner;

public class 숫자의개수_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        
        long result = A * B * C;
        
        String resultStr = String.valueOf(result);
        
        int[] count = new int[10];
        
        for (char c : resultStr.toCharArray()) {
            int digit = c - '0'; 
            count[digit]++;
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
    }    
}
