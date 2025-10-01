package backjoon.silver.lv4;

import java.io.*;
import java.util.*;

public class 포켓몬스터_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 포켓몬 도감 입력
        Map<String, Integer> strToNum = new HashMap<>();
        String[] numToStr = new String[N+1];

        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            // 여기에 저장 로직
            strToNum.put(pokemon, i);
            numToStr[i] = pokemon;
        }
        
        // 문제 입력
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            // 여기에 처리 로직
            if (Character.isDigit(query.charAt(0))) {
                System.out.println(numToStr[Integer.parseInt(query)]);
            } else {
                System.out.println(strToNum.get(query));
            }
        }
    }
}
