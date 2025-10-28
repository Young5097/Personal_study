package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기_18352 {

    static ArrayList<Integer>[] graph;
    static int[] distance;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  // 도시의 개수
        int M = Integer.parseInt(st.nextToken());  // 도로의 개수
        K = Integer.parseInt(st.nextToken());  // 거리 정보
        int X = Integer.parseInt(st.nextToken());  // 출발 도시 번호
        
        graph = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }
        distance = new int[N+1];
        Arrays.fill(distance, -1);
        bfs(X);

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                result.add(i);
            }
        }
        
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result); 
            for (int city : result) {
                System.out.println(city);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        distance[node] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll(); 
            for (int nxt : graph[cur]) {
                if (distance[nxt] == -1) {
                    distance[nxt] = distance[cur] + 1;
                    queue.add(nxt);
                }
            }
        }

    } 
}
