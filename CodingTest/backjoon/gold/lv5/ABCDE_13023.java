package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023 {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i=0;i<N;i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for (int i=0; i<N; i++) {
            if (found) break;
            dfs(i, 1);
        }

        System.out.println(found?1:0);
    }

    public static void dfs(int n, int depth) {
        if (depth==5) {
            found = true;
            return;
        }

        visited[n] = true;
        for (int node : graph[n]) {
            if (!visited[node] && !found) {
                dfs(node, depth+1);
            }
        }
        visited[n] = false;
    }
}

