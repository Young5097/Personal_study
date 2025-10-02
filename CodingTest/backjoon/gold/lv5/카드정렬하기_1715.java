package backjoon.gold.lv5;

import java.io.*;
import java.util.*;

public class 카드정렬하기_1715 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 카드 묶음 개수
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int cards = Integer.parseInt(br.readLine()); 
            pq.add(cards);
        }

        int answer = 0;
        for (int i=0; i<N-1; i++) {
            if (pq.size() == 1) {
                break;
            }
            int firstCards = pq.poll();
            int secondCards = pq.poll();
            int sum = firstCards + secondCards;
            answer += sum;
            pq.add(sum);
        }

        System.out.println(answer);
    }
}
