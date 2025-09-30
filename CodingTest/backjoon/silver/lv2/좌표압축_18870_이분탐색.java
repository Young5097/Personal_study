package backjoon.silver.lv2;

import java.io.*;
import java.util.*;

public class 좌표압축_18870_이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N 입력
        int N = Integer.parseInt(br.readLine());
        
        // N개의 좌표 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coords = new int[N];
        for (int i = 0; i < N; i++) {
            coords[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] sorted = Arrays.copyOf(coords, N);
        Arrays.sort(sorted);

        int[] temp = new int[N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || sorted[i] != sorted[i-1]) {
                temp[idx++] = sorted[i];
            }
        }
        int[] new_coords = Arrays.copyOf(temp, idx);

        for (int i = 0; i < N; i++) {
            int num = Arrays.binarySearch(new_coords, coords[i]);
            sb.append(num).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
