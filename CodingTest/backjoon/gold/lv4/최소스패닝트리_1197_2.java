package backjoon.gold.lv4;

import java.util.*;
import java.io.*;

public class 최소스패닝트리_1197_2 {

    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.cost = cost;
            this.to = to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 노드
        int E = Integer.parseInt(st.nextToken()); // 간선

        ArrayList<Edge>[] graph = new ArrayList[V+1];
        for (int i=0; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        boolean[] visited = new boolean[V+1];

        for (int i=0; i<E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());

            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));
        }

        // 출발지 설정
        visited[1] = true;
        for (Edge e : graph[1]) {
            pq.offer(e);
        }

        int count = 0;
        int totalCost = 0;

        while (count < V-1) {
            Edge cur = pq.poll();
            if (visited[cur.to]) continue; 

            visited[cur.to] = true;
            count++;
            totalCost += cur.cost;

            for (Edge nxt : graph[cur.to]) {
                if (visited[nxt.to]) continue;
                pq.offer(nxt);
            }
        }
        
        System.out.println(totalCost);
    }
}
