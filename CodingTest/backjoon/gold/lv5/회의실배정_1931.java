package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄: N(회의의 수) 입력
        int N = Integer.parseInt(br.readLine());

        List<int[]> councilList = new ArrayList<>(); 
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작시간
            int end = Integer.parseInt(st.nextToken()); // 끝나는시간
            councilList.add(new int[] {start, end});
        }
        
        Collections.sort(councilList, (a,b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int result = 0;
        int end = 0;
        for (int i=0; i<councilList.size(); i++) {
            int[] cur = councilList.get(i);
            if (end <= cur[0]) {
                result += 1;
                end = cur[1];
            }
        }  
        System.out.println(result);
    }
}
