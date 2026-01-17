package backjoon.bronze.lv5;

import java.util.Scanner;

public class ABC_31403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(A+B-C);

        String result2 = String.valueOf(A) + String.valueOf(B);
        System.out.println(Integer.parseInt(result2) - C);
        
    }
}
