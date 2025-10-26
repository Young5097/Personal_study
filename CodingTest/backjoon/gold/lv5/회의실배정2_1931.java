package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정2_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());  // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken());  // 종료 시간
        }

        Arrays.sort(meetings, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int cnt = 0;
        int end = 0;
        for (int i=0; i<N; i++) {
            if (meetings[i][0] >= end) {
                cnt++;
                end = meetings[i][1];
            }
        }
        System.out.println(cnt);
    }
}
