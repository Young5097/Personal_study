package backjoon.gold.lv4;

import java.util.*;
import java.io.*;

public class 최소스패닝트리_1197_크루스칼 {

    static class Edge {
        int a, b, cost;
        Edge(int a, int b, int cost) {
            this.cost = cost;
            this.a = a;
            this.b = b;
        }
    }

    static int[] parents;

    // 노드의 부모(그룹)를 찾기 + 부모 업데이트
    static int find(int x) { // ex) x=5 => parents[5] = 3 -> parents[3] =1 -> parents[1] = 1 => return 1;
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E+1];
        parents = new int[V+1];

        for (int i=0; i<E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            edges[i] = new Edge(a, b, cost);
        }

        for (int i=0; i<=V; i++) {
            parents[i] = i;
        }

        Arrays.sort(edges, 0, E, (a,b) -> a.cost - b.cost);

        int count = 0;
        int total_weight = 0;
        for (int i=0; i<E; i++) {
            int cost = edges[i].cost;
            int a = edges[i].a;
            int b = edges[i].b;

            // 초기에 간선들을 체크할때는 x와 parents[x]가 동일한 상태. 즉 그룹이 없음
            // 같은 부모인지를 통해 그룹을 확인(같은 부모 = 같은 그룹)
            if (find(a) != find(b)) { 
                // 그룹 업데이트 : b의 부모를 a로 변경
                parents[find(b)] = find(a);
                count++;
                total_weight += cost;
                if (count == V - 1) break;
            }
        }

        System.out.println(total_weight);
    }
}
