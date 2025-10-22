package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] ing = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            ing[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ing);

        int count = 0;
        int st_idx = 0;
        int en_idx = N-1;
        while (st_idx < en_idx) {
            if (ing[st_idx] + ing[en_idx] > M) {
                en_idx--;
            } else if (ing[st_idx] + ing[en_idx] < M) {
                st_idx++;
            } else { // 둘 중에 하나만 증가시키거나, 감소시키면 이후로 계속 작거나, 계속 크므로 st나 en 중 하나만 변화함
                count++;
                st_idx++; 
                en_idx--;
            }
        }

        System.out.println(count);
    }
}
