package backjoon.silver.lv1;

import java.util.Scanner;

public class 최대공약수_1850 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        
        StringBuilder sb = new StringBuilder();
        long result = gcd(A, B);
        while (result != 0) {
            sb.append("1");
            result--;
        }
        
        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b, a%b);
    }
}
