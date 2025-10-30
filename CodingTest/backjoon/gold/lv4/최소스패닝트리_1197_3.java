package backjoon.gold.lv4;

import java.util.*;
import java.io.*;

public class 최소스패닝트리_1197_3 {

    static class Edge {
        int a, b, cost;
        Edge(int a, int b, int cost) {
            this.cost = cost;
            this.a = a;
            this.b = b;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E+1];
        parents = new int[V+1];

        for (int i=1; i<=E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            edges[i] = new Edge(a, b, cost);
        }

        Arrays.sort(edges, 1, E, (a, b) -> a.cost - b.cost);

        for (int i=1; i<=V; i++) {
            parents[i] = i;
        }

        int totalCost = 0;
        int count = 0;
        for (int i=1; i<=E; i++) {
            Edge now = edges[i];

            if (find(now.a) != find(now.b)) {
                parents[find(now.b)] = find(now.a);
                totalCost += now.cost;
                count++;

                if (count >= V-1) break;
            }
        }

        System.out.println(totalCost);
    }
}
