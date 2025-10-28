package backjoon.gold.lv4;

import java.io.*;
import java.util.*;

public class 이분그래프_1707 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] group;
    static boolean isTwo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[V+1];
            visited = new boolean[V+1];
            group = new int[V+1];
            isTwo = true;

            for (int i=1; i<=V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            
            for (int i=1; i<=V; i++) {
                if (!visited[i]) {
                    group[i] = 0;
                    dfs(i);
                } 
                if (!isTwo) {
                    break;
                }
            }

            if (isTwo) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int nxt : graph[node]) {
            if (!visited[nxt]) {
                group[nxt] = (group[node]+1) % 2;
                dfs(nxt);
            } else if (group[node] == group[nxt]) { // 이미 방문한 곳인데 그룹도 같으면 이분그래프X
                isTwo = false;
            }
        }
    }
}
