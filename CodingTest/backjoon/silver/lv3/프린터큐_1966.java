package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐_1966 {
    static class Doc {
        int idx;
        int pri;
        Doc (int idx, int pri) {
            this.idx = idx;
            this.pri = pri;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            Queue<Doc> queue = new LinkedList<>();

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.add(new Doc(i, Integer.parseInt(st2.nextToken())));
            }
            
            int printCount = 0;

            while (!queue.isEmpty()) {
                Doc cur = queue.poll();
                boolean hasHigherPri = false;
                for (Doc other : queue) {
                    if (cur.pri < other.pri) {
                        hasHigherPri = true;
                        break;
                    }
                }
                
                if (hasHigherPri) {
                    queue.add(cur);
                } else {
                    printCount++;
                    if (cur.idx == M) {
                        System.out.println(printCount);
                        break;
                    }
                } 
            }
        }
    }
}

