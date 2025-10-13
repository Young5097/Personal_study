package backjoon.gold.lv3;

import java.util.*;
import java.io.*;

public class 최소비용2_11779_다익스트라 {
    static final int INF = 100000000;
    
    static class Edge {
        int to;
        int cost;
        
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 도시 개수
        int n = Integer.parseInt(br.readLine());
        // 버스 개수
        int m = Integer.parseInt(br.readLine());
        
        // 그래프 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 버스 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(from).add(new Edge(to, cost));
        }

        // 출발 도시와 도착 도시
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] d = new int[n+1]; // start에서 i까지의 거리비용 저장
        int[] pre = new int[n+1]; // 이전 정점을 저장

        Arrays.fill(d, INF);
        Arrays.fill(pre, -1);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        d[start] = 0;
        pq.add(new Edge(start, d[start]));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (d[cur.to] < cur.cost) continue; // 현재 정점까지의 비용보다 작은 경우에만 이동

            for (Edge nxt : graph.get(cur.to)) {
                int nxt_cost = cur.cost + nxt.cost;
                if (nxt_cost < d[nxt.to]) {
                    d[nxt.to] = nxt_cost;
                    pq.add(new Edge(nxt.to, nxt_cost));
                    pre[nxt.to] = cur.to;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int idx = end;
        while (idx != -1) {
            path.add(idx);
            idx = pre[idx]; // 이전 노드
        }
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        sb.append(d[end]).append("\n");
        sb.append(path.size()).append("\n");
        for (int city : path) {
            sb.append(city).append(" ");
        }
        System.out.print(sb);
    }
}
