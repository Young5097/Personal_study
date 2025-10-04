package backjoon.silver.lv2;

import java.io.*;
import java.util.*;

public class dfs와bfs_1260 {
    static StringBuilder sb_bfs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=1; i<=M; i++) { 
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
        
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i=1; i<=N; i++) { // 간선이 여러개이면, 정점이 작은거 먼저
            Collections.sort(graph.get(i));
        }

        // dfs
        List<Integer> order_dfs = new ArrayList<>();
        boolean[] visited_dfs = new boolean[N+1];
        StringBuilder sb_dfs = new StringBuilder();

        dfs(V, graph, visited_dfs, order_dfs);

        for (int node : order_dfs) {
            sb_dfs.append(node).append(" ");
        }
        System.out.println(sb_dfs.toString());

        // dfs2
        // List<Integer> order_dfs2 = new ArrayList<>();
        // boolean[] visited_dfs2 = new boolean[N+1];
        // Stack<Integer> stack = new Stack<>();

        // order_dfs2.add(V);
        // visited_dfs2[V] = true;
        // stack.add(V);

        // while (!stack.isEmpty()) {
        //     int cur_node = stack.pop();
        //     for (int nxt_node : graph.get(cur_node)) {
        //         if (visited_dfs2[nxt_node]) continue;
        //         order_dfs2.add(nxt_node);
        //         visited_dfs2[nxt_node] = true;
        //         stack.add(nxt_node);
        //     } 
        // }

        // bfs
        List<Integer> order_bfs = new ArrayList<>();
        boolean[] visited_bfs = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb_bfs = new StringBuilder();

        order_bfs.add(V);
        visited_bfs[V] = true;
        q.offer(V);

        while (!q.isEmpty()) {
            int cur_node = q.poll();
            for (int nxt_node : graph.get(cur_node)) {
                if (visited_bfs[nxt_node]) continue;
                order_bfs.add(nxt_node);
                visited_bfs[nxt_node] = true;
                q.offer(nxt_node);
            }
        }

        for (int node : order_bfs) {
            sb_bfs.append(node).append(" ");
        }
        System.out.println(sb_bfs.toString());


    }

    public static void dfs(int cur_node, List<List<Integer>> grpah, boolean[] visited, List<Integer> orders) {
        visited[cur_node] = true;
        orders.add(cur_node);

        for (int nxt_node : grpah.get(cur_node)) {
            if (visited[nxt_node] == true) continue;
            dfs(nxt_node, grpah, visited, orders);
        }
    }
}
