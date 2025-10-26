package backjoon.gold.lv5;

import java.util.Scanner;

public class 신기한소수_2023 {
    static int N;
    static int[] prime = {2, 3, 5, 7};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i=0; i<4; i++) {
            dfs(prime[i], 1);
        }
    }

    public static void dfs(int n, int len) {
        if (len == N) {
            if (isPrime(n)) System.out.println(n);
            return;
        }

        for (int i=1; i<=9; i++) {
            if (i%2 == 0) continue;
            int new_n = (n*10) + i;
            if (isPrime(new_n)) dfs(new_n, len+1);
        }
    }

    public static boolean isPrime(int n) {
        for (int i=2; i<n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }
}
