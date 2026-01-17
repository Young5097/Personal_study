package backjoon.bronze.lv5;

import java.util.Scanner;

public class 검증수_2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split(" ");

        int total = 0;
        for (String s : arr) {
            int n = Integer.parseInt(s);
            total += n*n;
        }
        System.out.println(total%10);
    }
    
}