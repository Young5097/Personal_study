package backjoon.gold.lv4;

import java.io.*;
import java.util.*;

public class 타임머신_11657 {

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 시작 도시
            int B = Integer.parseInt(st.nextToken()); // 도착 도시
            int C = Integer.parseInt(st.nextToken()); // 시간 (음수 가능)
            
            edges.add(new Edge(A, B, C));
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i=0; i<N-1; i++) { // 0~N-1까지인 이유는 1->N까지의 최단거리는 N-1의 간선을 가지기 때문
            for (Edge edge : edges) {
                if ((dist[edge.from] != INF) && (dist[edge.from] + edge.cost < dist[edge.to])) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                }
            }
        }

        boolean isCycle = false;
        for (Edge edge : edges) { // 최단거리이므로 더 작아져서는 안되는데 음수사이클이 있으면 최단거리가 의미X
            if ((dist[edge.from] != INF) && (dist[edge.from] + edge.cost < dist[edge.to])) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            System.out.println(-1);
        } else {
            for (int i=2; i<=N; i++) {
                if (dist[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
}
