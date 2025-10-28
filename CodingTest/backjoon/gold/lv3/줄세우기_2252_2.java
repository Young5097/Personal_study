package backjoon.gold.lv3;

import java.util.*;
import java.io.*;

// 위상정렬 : 사이클이 없는 그래프에서 노드의 순서를 구하는 알고리즘
// 받는 노드가 없는 노드(inDegree=0)부터 시작해 해당 노드와 연결된 노드의 진입 차수를 -1 해주며 모두 0이 될때까지 수행
// 이때 순서는 0이 되는 애들부터 Queue에 넣어서 정의

public class 줄세우기_2252_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDeg = new int[N+1];
        for (int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st2.nextToken());
            int post = Integer.parseInt(st2.nextToken());
            
            graph[pre].add(post);
            inDeg[post]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph[cur]) {
                inDeg[nxt]--;
                sb.append(cur).append(" ");
                if (inDeg[nxt] == 0) {
                    queue.add(nxt);
                }
            }
        }
    }
}
