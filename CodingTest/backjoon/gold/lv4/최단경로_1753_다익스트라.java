package backjoon.gold.lv4;

import java.util.*;
import java.io.*;

public class 최단경로_1753_다익스트라 {
    static final int INF = 100000000;

    static class Edge {
        int to; int cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(stz.nextToken());
        int E = Integer.parseInt(stz.nextToken());
        int start_idx = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        boolean[] fix = new boolean[V+1];
        int[] dis_arr = new int[V+1]; //  거리비용 배열

        for (int i=0; i<=V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++) {
            StringTokenizer stz2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz2.nextToken());
            int v = Integer.parseInt(stz2.nextToken());
            int cost = Integer.parseInt(stz2.nextToken());
        
            graph.get(u).add(new Edge(v, cost));
        }
        
        Arrays.fill(dis_arr, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        dis_arr[start_idx] = 0;
        pq.add(new Edge(start_idx, dis_arr[start_idx]));

        while(!pq.isEmpty()) {  
            Edge cur = pq.poll();

            if (fix[cur.to]) continue; // 확정된 정점은 패스
            fix[cur.to] = true;

            for (Edge nxt : graph.get(cur.to)) {
                int new_nxt_cost = cur.cost + nxt.cost;
                if (new_nxt_cost < dis_arr[nxt.to]) {
                    dis_arr[nxt.to] = new_nxt_cost;
                    pq.add(new Edge(nxt.to, new_nxt_cost));
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=V; i++) {
            if (dis_arr[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dis_arr[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
