package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최대힙_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n==0) {
                if (maxHeap.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(maxHeap.poll());
                }
            } else {
                maxHeap.add(n);
            }
            
        }
    }    
}
