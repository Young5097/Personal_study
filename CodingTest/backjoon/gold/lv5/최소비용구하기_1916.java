package backjoon.gold.lv5;

import java.io.*;
import java.util.*;

public class 최소비용구하기_1916 {
    static class Edge {
        int to;
        int cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
    
        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if (visited[now.to]) continue;
            visited[now.to] = true;

            for (Edge nxt : graph[now.to]) {
                int new_cost = now.cost + nxt.cost;
                if (new_cost < dis[nxt.to]) {
                    dis[nxt.to] = new_cost;
                    pq.offer(new Edge(nxt.to, new_cost));
                }
            }
        }

        System.out.println(dis[end]);
    }
}
