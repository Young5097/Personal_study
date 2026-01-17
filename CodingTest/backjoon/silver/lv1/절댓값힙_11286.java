package backjoon.silver.lv1;

import java.io.*;
import java.util.PriorityQueue;

public class 절댓값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 연산 개수
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA != absB) {
                return absA - absB;
            }

            return a - b;
        });

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                pq.add(n);
            } else {
                if (pq.size() == 0) {
                    System.out.println(0);
                } else {
                    int rm = pq.remove();
                    System.out.println(rm);
                }
            }
        }
    }
}