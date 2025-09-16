package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 휴게소세우기_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄: N(현재 휴게소 개수), M(더 지을 휴게소 개수), L(고속도로 길이)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        // 두 번째 줄: 현재 휴게소들의 위치 (N개)
        int[] restStops = new int[N];
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                restStops[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        Arrays.sort(restStops);
        
        List<Integer> distance = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            if (i==0) {
                distance.add(restStops[0]);
            } else if (i==N) {
                distance.add(L-restStops[N-1]);
            } else {
                distance.add(restStops[i]-restStops[i-1]);
            }

        }
    }
}