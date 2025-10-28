package backjoon.silver.lv1;

import java.util.*;
import java.io.*;

public class 효율적인해킹_1325 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        answer = new int[N+1];
        for (int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }

        int max = 0;
        for (int i=1; i<=N; i++) {
            if (answer[i] > max) max = answer[i];
        }
        for (int i=1; i<=N; i++) {
            if (answer[i] == max) System.out.print(i + " ");
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    queue.add(nxt);
                    visited[nxt] = true;
                    answer[node]++;
                }
            }
        }
    }
}
