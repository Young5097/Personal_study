package backjoon.gold.lv5;

import java.io.*;
import java.util.*;

public class 뱀과사다리게임_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        int[] map = new int[101];
        for (int i=1; i<=100; i++) {
            map[i] = i;
        }
        
        for (int i=0; i<n; i++) {
            String[] str2 = br.readLine().split(" ");
            int from = Integer.parseInt(str2[0]);
            int to = Integer.parseInt(str2[1]);
            map[from] = to;
        }
        
        for (int i=0; i<m; i++) {
            String[] str2 = br.readLine().split(" ");
            int from = Integer.parseInt(str2[0]);
            int to = Integer.parseInt(str2[1]);
            map[from] = to;
        }

        int[] dist = new int[101];
        boolean[] visited = new boolean[101];
        Queue<Integer> q = new LinkedList<>();

        visited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 100) {
                System.out.println(dist[100]);
                return;
            }

            for (int i=1; i<=6; i++) {
                int nxt = cur + i;
                if (nxt > 100) continue;
                
                int nxtPos = map[nxt];
                if (!visited[nxtPos]) {
                    visited[nxtPos] = true;
                    q.add(nxtPos);
                    dist[nxtPos] = dist[cur] + 1;
                }
            }
        }
    }
}