package backjoon.silver.lv3;

// 에라토스테네스의 체

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력: M N (M이상 N이하의 소수를 구하는 문제)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        boolean[] isNotPrime = new boolean[N+1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i=2; i*i<=N; i++) {
            if (isNotPrime[i]) continue;
            for (int j=i*i; j<=N; j+=i) { // 이전 합성수에서 i의 배수들은 모두 true 처리되므로 이렇게 함
                isNotPrime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=M; i<=N; i++) {
            if (!isNotPrime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }       
}
