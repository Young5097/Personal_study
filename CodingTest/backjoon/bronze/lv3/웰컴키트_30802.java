package backjoon.bronze.lv3;

import java.util.Scanner;

public class 웰컴키트_30802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        long[] sizes = new long[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = sc.nextLong();
        }
        long T = sc.nextLong();
        long P = sc.nextLong();
        
        long total = 0;
        for (int i = 0; i < 6; i++) {
            total += Math.ceil((double) sizes[i]/T);
        }

        System.out.println(total);

        long pen_total = N/P;
        long pen_detail = N%P;
        System.out.println(pen_total + " " + pen_detail);

        sc.close();
    }
}
