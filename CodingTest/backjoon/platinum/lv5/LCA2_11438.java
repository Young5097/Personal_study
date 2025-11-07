package backjoon.platinum.lv5;

import java.io.*;
import java.util.*;

public class LCA2_11438 {
    static ArrayList<Integer>[] graph;
    static int maxDepth;
    static int[] depth;
    static int[][] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i=1;i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }

        depth = new int[N+1];
        visited = new boolean[N+1];
        maxDepth = (int) Math.ceil(Math.log(N)/Math.log(2));

        // depth 구하기
        bfs(1);

        parent = new int[N+1][maxDepth+1];

        int M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 여기서 LCA 구하고 출력
        }
    }

    static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        visited[root] = true;
        depth[root] = 0;
        parent[root][0] = 0; 
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            maxDepth = Math.max(maxDepth, depth[cur]);

            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    depth[nxt] = depth[cur] + 1;
                    parent[nxt][0] = cur;
                    q.offer(nxt);
                }
            }
        }
    }
}
