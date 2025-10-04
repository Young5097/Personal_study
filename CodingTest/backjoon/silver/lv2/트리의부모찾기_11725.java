package backjoon.silver.lv2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            tree[a].add(b);
            tree[b].add(a);
        }

        visited = new boolean[N+1];
        parent = new int[N+1];
        dfs(1);

        StringBuilder sb = new StringBuilder();

        for (int i=2; i<=N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int current_node) {
        visited[current_node] = true;

        for (int nxt_node : tree[current_node]) {
            if (!visited[nxt_node]) {
                parent[nxt_node] = current_node;
                dfs(nxt_node);
            }
        }
    }
}
