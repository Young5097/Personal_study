package 자료구조;

import java.util.*;

public class 다익스트라 {
    static class Edge {
        int to;
        int weight;
        
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static final int INF = 100000000;
    static List<List<Edge>> adj = new ArrayList<>();
    static boolean[] fix = new boolean[20005]; // 고정여부 체크배열
    static int[] d = new int[20005]; // 거리배열
    static int v = 10; 

    public static void dijkstra_native(int st) {
        Arrays.fill(d, INF);
        Arrays.fill(fix, false);

        d[st] = 0;

        while(true) {
            int idx = -1;

            for (int i=1; i<=v; i++) {
                if (fix[i]) continue; // 확정된 정점인지
                if (idx == -1) idx = 1; // 첫번째 미확인 정점
                else if (d[i] < d[idx]) idx = i; // 아직 확정되지 않은 정점 중, 거리가 최소인 정점
            }

            if (idx == -1 || d[idx] == INF) break; // 더이상 선택할 정점이 없는 경우

            fix[idx] = true;

            // 인접한 정점들의 거리 갱신
            for (Edge nxt : adj.get(idx)) {
                d[nxt.to] = Math.min(d[nxt.to], d[idx] + d[nxt.weight]);
            }
        }
    }

    public static void main(String[] args) {
        // 인접 리스트 초기화
        for (int i = 0; i <= 20000; i++) {
            adj.add(new ArrayList<>());
        }
        
        // 예시: 간선 추가 (from, to, weight)
        adj.get(1).add(new Edge(2, 2));
        adj.get(1).add(new Edge(3, 3));
        adj.get(2).add(new Edge(3, 4));
        adj.get(2).add(new Edge(4, 5));
        adj.get(3).add(new Edge(4, 6));
    }
}
