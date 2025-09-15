package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정_1931_그리디 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄: N(회의의 수) 입력
        int N = Integer.parseInt(br.readLine());

        // 회의 정보를 저장할 2차원 배열
        int[][] meetings = new int[N][2];

        // 둘째 줄부터: N개의 회의 정보 입력 (시작시간, 끝나는시간)
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 끝나는시간
        }

        Arrays.sort(meetings, (a,b) -> {
            if (a[1] == b[1]) return a[0]-b[0];
            else return a[1]-b[1];
        });

        int result = 0;
        int last_end = 0;
        for (int i=0; i<N; i++) {
            if (meetings[i][0] < last_end) continue;
            result++;
            last_end = meetings[i][1];
        }

        System.out.println(result);
    }
}
