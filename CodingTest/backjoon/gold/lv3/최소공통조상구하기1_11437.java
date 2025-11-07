package backjoon.gold.lv3;

import java.io.*;
import java.util.*;

public class 최소공통조상구하기1_11437 {
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static int[] depth;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 노드 개수
        int N = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 트리 간선 입력 (N-1개)
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 양방향 연결
            graph[a].add(b);
            graph[b].add(a);
        }

        // BFS를 통해 트리,depth 구하기
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        depth[1] = 0;
        parent[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    parent[nxt] = cur;
                    depth[nxt] = depth[cur] + 1;
                    queue.offer(nxt);
                }
            }
        }

        int M = Integer.parseInt(br.readLine()); // 쿼리 갯수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(findParent(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static int findParent(int a, int b) {
        while (depth[a] > depth[b]) {
            a = parent[a];
        }
        while (depth[b] > depth[a]) {
            b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
