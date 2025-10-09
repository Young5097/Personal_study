package backjoon.gold.lv2;

import java.util.*;
import java.io.*;

public class 물대기_1368_크루스칼 {

    static int[] parents;

    static class Edge {
        int a; int b; int cost;
        Edge (int a, int b, int cost) {
            this.cost = cost;
            this.a = a;
            this.b = b;
        }
    }

    static int findParents(int x) {
        if (parents[x] != x) {
            parents[x] = findParents(parents[x]);
        }
        return parents[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Edge> edgeList = new ArrayList<>();
        parents = new int[N+1]; // 해당 노드의 부모 노드(간선을 타고 올라갔을때)

        for (int i=1; i<=N; i++) {
            int cost = Integer.parseInt(br.readLine());
            edgeList.add(new Edge(0, i, cost)); // 가상의 노드 0번을 우물파는 곳으로 가정
        }

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i<j) { // 양방향 간선이므로 중복제거
                    edgeList.add(new Edge(i, j, cost));
                }
            }
        }
        
        for (int i=0; i<=N; i++) { // 부모(그룹) 초기화
            parents[i] = i;
        }

        Collections.sort(edgeList, (a, b) -> a.cost - b.cost);

        int count = 0;
        int totalCost = 0;
        for (int i=0; i<edgeList.size(); i++) {
            Edge curEdge = edgeList.get(i);
            int a = curEdge.a;
            int b = curEdge.b;
            int cost = curEdge.cost;
            
            if (findParents(a) != findParents(b)) {
                parents[findParents(b)] = findParents(a);
                count++;
                totalCost += cost;

                if (count == N) break; // 임의의 노드 0을 추가했기 때문
            }
        }

        System.out.println(totalCost);
    }
}
