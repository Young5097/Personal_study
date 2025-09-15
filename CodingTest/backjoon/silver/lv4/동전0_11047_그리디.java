package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0_11047_그리디 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫째 줄: N(동전 종류 개수)과 K(목표 금액) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 둘째 줄부터: N개의 동전 가치 입력 (오름차순으로 주어짐)
        int[] coins = new int[N];
        
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i=N-1; i>=0; i--) {
            result += K/coins[i];
            K %= coins[i]; 
        }

        System.out.println(result);
    }
}
