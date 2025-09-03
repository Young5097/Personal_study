package backjoon.silver.lv1;

/*
 * https://www.acmicpc.net/problem/1629
 *
 * 거듭제곱의 분할정복과 모듈러 성질 이용
 * 거듭제곱의 분할정복 : 2^12 = 2^6 * 2^6
 *  - 짝수 제곱 : (A^(B/2))^2
 *  - 홀수 제곱 : (A^(B/2))^2 * A
 * 모듈러 성질 : 중간 마다 C로 나눈 나머지를 구해 오버플로우를 막음 
 * - 예시로  (3 * 5) % 7 -> (3 % 7) * (5 % 7) % 7 = 3 * 5  * 7 = 1
 * - (A * B) % C = ((A % C) * (B % C)) % C
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셉_1629_재귀 {
    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);

        long result = pow(A, B, C);
        System.out.println(result);
    }

    public static long pow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long half = pow(a, b / 2, c);
        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return ((half * half) % c * a % c) % c;
        }
    }
}
