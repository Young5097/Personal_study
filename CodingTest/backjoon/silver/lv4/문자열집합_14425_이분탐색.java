package backjoon.silver.lv4;

import java.io.*;
import java.util.*;

public class 문자열집합_14425_이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] S = new String[N];        
        for (int i=0; i<N; i++) {
            S[i] = br.readLine();
        }

        Arrays.sort(S);

        int count = 0;
        for (int i=M; i<M; i++) {
            if (Arrays.binarySearch(S, br.readLine()) >= 0) { // 이분탐색으로 해당값이 있으면 index 반환. 없으면 음수값
                count++;
            }
        }

        System.out.println(count);
    }
}
