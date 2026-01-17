package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 케빈베이컨6단계_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<=m; i++) {
            String[] str2 = br.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i=1; i<=n; i++) {
            int bacon = bfs(i, graph, n);
            if (bacon < min) {
                min = bacon;
                answer = i;
            }
        }

        System.out.println(answer);
    }  

    // 최단거리이므로 bfs
    public static int bfs(int start, ArrayList<Integer>[] graph, int n) {
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);
        int sum = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    dist[nxt] = dist[cur] + 1;
                    sum += dist[nxt];
                    queue.add(nxt);
                }
            }
        }

        return sum;
    }
}
