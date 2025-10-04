package backjoon.gold.lv3;

import java.util.*;
import java.io.*;

public class 줄세우기_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }        

        int[] inDig = new int[N+1];
        for (int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st2.nextToken());
            int post = Integer.parseInt(st2.nextToken());

            graph[pre].add(post);
            inDig[post]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            if (inDig[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int nxt : graph[cur]) {
                inDig[nxt]--;
                if (inDig[nxt] == 0) {
                    queue.add(nxt);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
