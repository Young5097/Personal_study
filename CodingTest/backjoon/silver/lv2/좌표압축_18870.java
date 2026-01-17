package backjoon.silver.lv2;

import java.io.*;
import java.util.*;

public class 좌표압축_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N 입력
        int N = Integer.parseInt(br.readLine());
        
        // N개의 좌표 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] sortedPoints = Arrays.copyOf(points, N);
        Arrays.sort(sortedPoints);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int i=0; i<N; i++) {
            int num = sortedPoints[i];
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank += 1;
            }
        }

        for (int i=0; i<N; i++) {
            sb.append(rankMap.get(points[i])).append(" ");
        }
        System.out.println(sb);
    }
}
