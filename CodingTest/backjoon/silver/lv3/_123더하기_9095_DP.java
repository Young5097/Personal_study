package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _123더하기_9095_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            
            // 여기에 문제 풀이 코드 작성
            int result = solve(n);  // solve 함수는 여러분이 구현
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int solve(int n) {
        int[] table = new int[20];
        table[1] = 1;
        table[2] = 2;
        table[3] = 4;
        for (int i=4; i<=n; i++) {
            table[i] = table[i-1] + table[i-2] + table[i-3];
        }
        return table[n];
    }
}
