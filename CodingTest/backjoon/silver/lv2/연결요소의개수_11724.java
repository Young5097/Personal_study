package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int count = 0;
        boolean[] visited = new boolean[n+1];

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i=1; i<=n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            queue.add(i);
            count+=1;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int nxt : graph[cur]) {
                    if (!visited[nxt]) {
                        visited[nxt] = true;
                        queue.add(nxt);
                    }
                }
            }
        }
        
        // dfs
        // for (int i=1; i<=n; i++) {
        //     if (visited[i]) continue;
        //     count+=1;
        //     dfs(i, graph, visited);
        // }

        System.out.println(count);
    }

    public static void dfs(int cur, ArrayList<Integer>[] graph, boolean[] visited) {
        if (visited[cur]) return;
        visited[cur] = true;
        
        for (int nxt : graph[cur]) {
            if (visited[nxt]) continue;
            dfs(nxt, graph, visited);
        }
    }
}
