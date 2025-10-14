package backjoon.silver.lv4;

import java.io.*;
import java.util.*;

public class 문자열집합_14425_hash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        for (int i=M; i<M; i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
