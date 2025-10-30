package backjoon.gold.lv3;

import java.util.*;
import java.io.*;

public class 불우이웃돕기_1414 {
    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Edge> edges = new ArrayList<>();
        int all_cost = 0;

        for (int i=0; i<N; i++) {
            char[] c_arr = br.readLine().toCharArray();
            for (int j=0; j<N; j++) {
                char c = c_arr[j];
                if (c == '0') continue;

                int cost = 0;
                if (c >= 'a' && c <= 'z') {
                    cost = c - 'a' + 1;
                } else if (c >= 'A' && c <= 'Z') {
                    cost = c - 'A' + 27;
                }

                all_cost += cost;
                if (i != j) edges.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(edges, (a,b) -> a.cost - b.cost);

        parents = new int[N+1];
        for (int i=0; i<=N; i++) {
            parents[i] = i;
        }

        int total_cost = 0;
        int count = 0;
        for (Edge e : edges) {
            int from = e.from;
            int to = e.to;
            int cost = e.cost;

            if (find(from) != find(to)) {
                parents[find(to)] = find(from);
                total_cost += cost;
                count++;
            } 

            if (count == N-1) break;
        }

        if (count < N-1) {
            System.out.println(-1);
        } else {
            System.out.println(all_cost - total_cost);
        }
    }
}