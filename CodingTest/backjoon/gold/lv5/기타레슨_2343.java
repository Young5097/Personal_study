package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  // 강의 수
        int M = Integer.parseInt(st.nextToken());  // 블루레이 개수
        // 가장 작은 블루레이는 가장 긴 강의, 가장 큰 블루레이는 강의의 총합
        int start = 0; // 
        int end = 0;

        int[] lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            if (start < lectures[i]) start = lectures[i];
            end += lectures[i];
        }
        
        while (start<=end) {
            int mid = (start+end)/2;
            int sum  = 0;
            int count = 0;
            for (int i=0; i<N; i++) {
                if (sum + lectures[i] > mid) {
                    count++;
                    sum=0;
                }
                sum += lectures[i];
            }
            if (sum != 0) count++;
            if (count > M) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        System.out.println(start);
    }
}
