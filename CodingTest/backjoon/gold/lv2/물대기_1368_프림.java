package backjoon.gold.lv2;

import java.util.*;
import java.io.*;

public class 물대기_1368_프림 {

    static boolean[] visited;

    static class Edge {
        int to; int cost;
        Edge (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        visited = new boolean[N+1]; 

        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++) {
            int cost = Integer.parseInt(br.readLine());
            graph[0].add(new Edge(i, cost));
            graph[i].add(new Edge(0, cost));
        }

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                graph[i].add(new Edge(j, cost));
            }
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        for (Edge e : graph[0]) {
            pq.offer(e);
        }

        int count = 0;
        int totalCost = 0;
        visited[0] = true;

        while (count < N) { // 0번 노드가 추가됐으니 간선은 N개
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            count++;
            totalCost+= cur.cost;

            for (Edge nxt : graph[cur.to]) {
                if (!visited[nxt.to]) {
                    pq.offer(nxt);
                }
            }
        }

        System.out.println(totalCost);
    }
}
