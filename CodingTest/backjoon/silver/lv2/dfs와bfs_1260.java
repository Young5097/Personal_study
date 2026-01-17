package backjoon.silver.lv2;

import java.io.*;
import java.util.*;

public class dfs와bfs_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++) {
            String[] node = br.readLine().split(" ");
            int a = Integer.parseInt(node[0]);
            int b = Integer.parseInt(node[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }

        StringBuilder sb = new StringBuilder();

        // dfs
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        dfs(V, graph, result, visited);

        for (int n : result) {
            sb.append(n).append(" ");
        }
        sb.append("\n");

        // bfs
        List<Integer> result2 = new ArrayList<>();
        boolean[] visited2 = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited2[cur]) continue;
            visited2[cur] = true;
            result2.add(cur);
            
            for (int nxt : graph[cur]) {
                if (!visited2[nxt]) {
                    queue.offer(nxt);
                }
            }
        }

        for (int n : result2) {
            sb.append(n).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);
    }

    static void dfs(int cur, ArrayList<Integer>[] graph, List<Integer> result, boolean[] visited) {
        visited[cur] = true;
        result.add(cur);

        for (int nxt : graph[cur]) {
            if (!visited[nxt]) {
                dfs(nxt, graph, result, visited);
            }
        }
    }
}
