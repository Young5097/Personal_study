package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n==0) {
                if (minHeap.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(minHeap.poll());
                }
            } else {
                minHeap.add(n);
            }
            
        }
    }    
}
