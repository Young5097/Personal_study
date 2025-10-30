package backjoon.platinum.lv4;

import java.io.*;
import java.util.*;

public class K번째최단경로찾기_1854 {

    static class Edge {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 수
        int M = Integer.parseInt(st.nextToken()); // 도로의 수
        int K = Integer.parseInt(st.nextToken()); // K번째 최단경로

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph[from].add(new Edge(to, cost));
        }

        List<PriorityQueue<Integer>> costList = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            costList.add(new PriorityQueue<Integer>(Collections.reverseOrder()));
        }
        costList.get(1).offer(0);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (Edge nxt : graph[now.node]) {
                int newCost = now.cost + nxt.cost;

                if (costList.get(nxt.node).size() < K) {
                    costList.get(nxt.node).offer(newCost);
                    pq.offer(new Edge(nxt.node, newCost));
                }
                if (newCost < costList.get(nxt.node).peek()) {
                    costList.get(nxt.node).poll();
                    costList.get(nxt.node).offer(newCost);
                    pq.offer(new Edge(nxt.node, newCost));
                }
            }
        }

        for (int i=1; i<=N; i++) {
            if (costList.get(i).size() < K) {
                System.out.println(-1);
            } else {
                System.out.println(costList.get(i).poll());
            }
        }
    }
}
