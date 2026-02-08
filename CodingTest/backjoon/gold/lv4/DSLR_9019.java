package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DSLR_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            String[] str = br.readLine().split(" ");
            int st = Integer.parseInt(str[0]);
            int en = Integer.parseInt(str[1]);

            if (st==en) {
                System.out.println("");
                continue;
            }

            int[] parents = new int[10000];
            int[] nxtCommmands = new int[10000];
            // String[] commands = new String[10000];
            boolean[] visited = new boolean[10000];
            Queue<Integer> queue = new LinkedList<>();

            // commands[st]= "";
            queue.add(st);
            visited[st] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if (cur == en) {
                    break;
                }

                int[] nexts = {commandD(cur), commandS(cur), commandL(cur), commandR(cur)};
                // char[] ops = {'D', 'S', 'L', 'R'};
                
                for (int i=0; i<4; i++) {
                    int nxt = nexts[i];
                    
                    if (!visited[nxt]) {
                        // commands[nxt] = commands[cur] + ops[i]; 
                        parents[nxt] = cur;
                        nxtCommmands[nxt] = i;
                        visited[nxt] = true;
                        queue.add(nxt);
                    }
                }
            }
            // System.out.println(commands[en]);
            
            StringBuilder sb = new StringBuilder();
            char[] ops = {'D', 'S', 'L', 'R'};
            int cur = en;
            while(cur != st) {
                sb.append(ops[nxtCommmands[cur]]);
                cur = parents[cur];
            }
            System.out.println(sb.reverse());
        }
    }

    static int commandD(int n) {
        return (n * 2) % 10000;
    }

    static int commandS(int n) {
        return (n != 0)?n-1:9999;
    }

    static int commandL(int n) {
        return (n%1000) * 10 + (n/1000);
    }

    static int commandR(int n) {
        return (n%10) * 1000 + (n/10);

    }
}
