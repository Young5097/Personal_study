 package backjoon.gold.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합_10986 {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  // 수의 개수
        int M = Integer.parseInt(st.nextToken());  // 나누어떨어지는 수
        
        long[] sum = new long[N];  // 누적 합
        long[] count = new long[M];
        
        /*
             i~j의 구간합은 sum[j]-[i]이고 m으로 나누었을 때 0이 되어야함
             이때 구간합의 나머지가 같은 쌍들은 m으로 나누었을 때 무조건 0이 된다
             만약 m이 3이고 나머지가 2일 때? 
             (sum[j] - sum[i]) % m -> (sum[j]%m - sum[i]%m) % m -> (2-2) % 3 -> 0
         */
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st2.nextToken());
        for (int i=1; i<N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st2.nextToken());
        }

        long result = 0;
        for (int i=0; i<N; i++) {
            int remain = (int) (sum[i]%M);
            if (remain == 0) result++;
            count[remain]++;
        }

        for (int i=0; i<M; i++) {
            if (count[i] > 0) {
                result += count[i]*(count[i]-1)/2;
            }
        }

        System.out.println(result);
    }
 }