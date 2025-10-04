package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // bfs 
        boolean[] visited = new boolean[n+1];
        int num = 0;
        for (int i=1; i<=n; i++) {
            if (visited[i]) continue;
            num++;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int cur_node = queue.poll();
                for (int nxt_node : graph.get(cur_node)) {
                    if (visited[nxt_node]) continue;
                    queue.offer(nxt_node);
                    visited[nxt_node] = true;
                }
            }
        }

        System.out.println(num);

        // dfs1
        boolean[] visited2 = new boolean[n+1];
        int num2 = 0;
        for (int i=1; i<=n; i++) {
            if (visited2[i]) continue;
            num2++;
            dfs(i, graph, visited2);
        }

        // dfs2
        boolean[] visited3 = new boolean[n+1];
        int num3 = 0;

        for (int i=1; i<=n; i++) {
            if (visited3[i]) continue;
            num3++;
            Stack<Integer> stack = new Stack<>();
            stack.add(i);
            visited3[i] = true;
            while (!stack.isEmpty()) {
                int cur_node = stack.pop();
                for (int nxt : graph.get(cur_node)) {
                    if (visited3[nxt]) continue;
                    stack.add(nxt);
                    visited3[nxt] = true;
                }
            }
        }
    }

    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int nxt : graph.get(node)) {
            if (!visited[nxt]) {
                dfs(nxt, graph, visited);
            }
        }
    }
}
