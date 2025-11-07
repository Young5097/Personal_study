package backjoon.gold.lv5;

import java.io.*;
import java.util.*;

public class 트리_1068 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int rmNode;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int rootNode= -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                rootNode = i;
            } else {
                graph[parent].add(i);
            }
        }
        
        rmNode = Integer.parseInt(br.readLine());
        if (rmNode == rootNode) {
            System.out.println(0);
            return;
        }

        // visited[rmNode] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(rootNode);
        
        answer = 0; // 자식이 없는 리프노드
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            visited[cur] = true;
            
            int curNodeCount = 0; // 현재 노드가 가진 자식 카운트
            for (int nxt : graph[cur]) {
                // if (!visited[nxt]) {
                if (!visited[nxt] && nxt != rmNode) {
                    curNodeCount++;
                    stack.push(nxt);
                }
            }

            if (curNodeCount == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int cur) {
        visited[cur] = true;

        int cNode = 0;
        for (int nxt : graph[cur]) {
            if (!visited[nxt] && nxt != rmNode) {
                cNode++;
                dfs(nxt);
            }
        }

        if (cNode == 0) {
            answer++;
        }
    }
}
