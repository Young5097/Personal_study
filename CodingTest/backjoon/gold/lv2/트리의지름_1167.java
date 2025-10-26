package backjoon.gold.lv2;

import java.util.*;
import java.io.*;

public class 트리의지름_1167 {

    static ArrayList<int[]>[] graph;
    static Integer[] distacne;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[V+1];
        for (int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        } 

        for (int i=1; i<=V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) break;
                int w = Integer.parseInt(st.nextToken());
                graph[start].add(new int[] {e, w});
            }
        }
        
        // 1. 1번 노드에서 가장 멀리있는 노드를 먼저 찾음
        visited = new boolean[V+1];
        distacne = new Integer[V+1];
        Arrays.fill(distacne, 0);
        bfs(1);
        
        // 2. 가장 멀리있는 노드값을 찾기
        int maxFarE = 1;
        for (int i=2; i<distacne.length; i++) {
            if (distacne[i] > distacne[maxFarE]) {
                maxFarE = i;
            }
        }
        
        // 3. 사용되는 배열들을 초기화 후, maxFarNode에서 각 노드들까지의 거리를 구함
        visited = new boolean[V+1];
        distacne = new Integer[V+1];
        Arrays.fill(distacne, 0);
        bfs(maxFarE);

        // 4. distance의 최댓값 out
        Arrays.sort(distacne, Comparator.reverseOrder());
        System.out.println(distacne[0]);
    }

    static void bfs(int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(e); 
        visited[e] = true;

        while (!queue.isEmpty()) {
            int cur_e = queue.poll();

            for (int[] edge : graph[cur_e]) {
                int nxt_e = edge[0];
                int weight = edge[1];

                if (!visited[nxt_e]) {
                    visited[nxt_e] = true;
                    distacne[nxt_e] = distacne[cur_e] + weight;
                    queue.add(nxt_e);
                }
            }
        }
    }
}
