package backjoon.gold.lv4;

import java.util.*;
import java.io.*;

public class 최단경로_1753_2 {

    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start_idx = Integer.parseInt(br.readLine());
    
        ArrayList<Edge>[] graph = new ArrayList[V+1];
        for (int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }
    
        for (int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));
        }

        int[] answer = new int[V+1];
        Arrays.fill(answer, INF);
        answer[start_idx] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.offer(new Edge(start_idx, answer[start_idx])); // start_idx부터 시작하니 변수가 to라 해서 헷갈리지 말자

        boolean[] visited = new boolean[V+1];

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.to]) continue;
            visited[now.to] = true;

            for (Edge nxt : graph[now.to]) {
                int new_weight = now.weight + nxt.weight;
                if (new_weight < answer[nxt.to]) {
                    answer[nxt.to] = new_weight;
                    pq.offer(new Edge(nxt.to, new_weight));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=V; i++) {
            if (answer[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(answer[i]).append("\n");
            }
        }
        System.out.print(sb);
    }   
}
