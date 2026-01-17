package backjoon.gold.lv5;

import java.util.Scanner;

public class Z_1074_재귀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int result= z(n, r, c);
        System.out.println(result);
    }

    public static int z(int n, int r, int c) {
        if (n==0) {
            return 0;
        }

        int half = (int) Math.pow(2, n-1);
        if (r < half && c < half) {
            return z(n-1, r, c);
        } else if (r < half && c >= half) {
            return (half*half) + z(n-1, r, c-half);
        } else if (r >= half && c < half) {
            return (half*half*2) + z(n-1, r-half, c);
        } else {
            return (half*half*3) + z(n-1, r-half, c-half);
        }
    }
}
