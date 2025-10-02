package backjoon.gold.lv2;

import java.io.*;
import java.util.*;

public class 보석도둑_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수
        
        // 보석 정보 저장
        int[][] jewels = new int[N][2]; // [무게, 가격]
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken()); // 무게
            jewels[i][1] = Integer.parseInt(st.nextToken()); // 가격
        }
        
        // 가방 정보 저장
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine()); // 최대 무게
        }
        
        // 가방은 무게순으로 오름차순 정렬
        // 보석은 무게순으로 오름차순 정렬
        Arrays.sort(bags);
        Arrays.sort(jewels, (a,b) -> a[0] - b[0]);
        // 가치를 내림차순으로 저장 : 가장 큰 거를 뽑기위해서
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int idx = 0;
        // 가방크기가 5, 5이고 보석이 [5,10], [5,10]? 
        // pq에 그대로 저장되어 있음. 그리고 다음 가방은 이전 가방보다 무게가 크므로 문제없이 넣을 수 있음
        // 1. 이전 가방에 들어갈 수 있는 보석들은 다음 가방에도 들어갈 수 있음(무게순 오름차순)
        // 2. 따라서 이전가방에서 들어갈 수 있지만 우선순위에서 밀린 보석들은 다음 가방에서도 경쟁함
        for (int bag : bags) {
            while (idx < N && jewels[idx][0] <= bag) {
                pq.offer(jewels[idx][1]);
                idx++;
            }
            if (!pq.isEmpty()) answer += pq.poll();
        }

        System.out.println(answer);
    }
}
