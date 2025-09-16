package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N으로 나눴을 때 x, M으로 나눴을 때 y인 값
public class 카잉달력_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = solve(M, N, x, y);
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int solve (int M, int N, int x, int y) {
        if (x==M) x=0;
        if (y==N) y=0;
        int lcm = lcm(M, N);
        for (int i=x; i<=lcm; i++) {
            if (i%M == x && i%N == y) {
                return i;
            }
        }
        return -1;
    }

    public static int gcd(int a, int b) { // 최대공약수
        if (b==0) return a;
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b) { // 최소공배수
        return a / gcd(a, b) * b;
    }
}
