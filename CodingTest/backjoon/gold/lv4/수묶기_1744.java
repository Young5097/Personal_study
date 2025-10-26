package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수묶기_1744 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pqPlus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMinus = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n>1) {
                pqPlus.add(n);
            } else if (n<0) {
                pqMinus.add(n);
            } else if (n==1) {
                one++;
            } else {
                zero++;
            }
        }

        int total = 0;
        while (!pqPlus.isEmpty()) {
            if (pqPlus.size() == 1) {
                total += pqPlus.poll();
                break;
            }
            int fisrt = pqPlus.poll();
            int second = pqPlus.poll();
            total += (fisrt*second);
        }
        while (!pqMinus.isEmpty()) {
            if(pqMinus.size() == 1) {
                int last = pqMinus.poll();
                if (zero == 0) {
                    total+=last;
                }
                break;
            }
            int fisrt = pqMinus.poll();
            int second = pqMinus.poll();
            total += (fisrt*second);
        }
        total+=one;
        System.out.println(total);
    }
}
