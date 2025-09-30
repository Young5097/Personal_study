package backjoon.silver.lv4;

import java.io.*;
import java.util.*;

public class 수찾기_1920_이분탐색 {
    static int[] A;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] queries = new int[M];
        for (int i = 0; i < M; i++) {
            queries[i] = Integer.parseInt(st.nextToken());
        }
        
        // 여기에 로직 추가
        Arrays.sort(A);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<queries.length; i++) {
            // sb.append(binarySearch(queries[i])).append("\n");
            int result = Arrays.binarySearch(A, queries[i]);
            if (result >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static int binarySearch(int target) {
        int st = 0;
        int en = N-1;

        while (st <= en) {
            int mid = (st+en)/2;
            if (A[mid] < target) {
                st = mid+1;
            } else if (A[mid] > target) {
                en = mid-1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}