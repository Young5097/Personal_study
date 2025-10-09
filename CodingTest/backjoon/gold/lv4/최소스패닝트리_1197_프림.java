package backjoon.gold.lv4;

import java.util.*;
import java.io.*;

public class 최소스패닝트리_1197_프림 {

    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.cost = cost;
            this.to = to;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 노드
        int E = Integer.parseInt(st.nextToken()); // 간선

        ArrayList<Edge>[] graph = new ArrayList[V+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        visited = new boolean[V+1];

        for (int i=0; i<= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            
            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));
        }

        // 초기 노드 설정
        visited[1] = true;
        for (Edge e : graph[1]) {
            pq.offer(e);
        }

        int count = 0;
        int totalWeight = 0;
        while (count < V - 1) {
            Edge curEdge = pq.poll();
            if (visited[curEdge.to]) continue;

            visited[curEdge.to] = true;
            count++;
            totalWeight += curEdge.cost;

            for (Edge nxtEdge : graph[curEdge.to]) {
                if (!visited[nxtEdge.to]) {
                    pq.offer(nxtEdge);
                }
            }
        }

        System.out.println(totalWeight);
    }
}
