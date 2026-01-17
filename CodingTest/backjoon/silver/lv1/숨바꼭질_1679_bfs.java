package backjoon.silver.lv1;

/*
 * https://www.acmicpc.net/problem/1697
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질_1679_bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 수빈이의 위치
        int K = Integer.parseInt(input[1]); // 동생의 위치

        int result = bfs(N, K);
        System.out.println(result);
    }

    public static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[100001];
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == target) {
                return dist[cur];
            }

            int[] next = {cur-1, cur+1, cur*2};
            for (int nxt : next) {
                if (nxt >= 0 && nxt < 100001 && dist[nxt]==0) {
                    dist[nxt] = dist[cur] + 1;
                    queue.offer(nxt);
                } 
            }
        
        }

        return -1;
    }

    public static int bfs2(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.offer(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cur = current[0];
            int depth = current[1];

            if (cur == target) {
                return depth;
            }

            int[] next = {cur-1, cur+1, cur*2};
            for (int nxt : next) {
                if (nxt >= 0 && nxt < 100001 && !visited[nxt]) {
                    queue.offer(new int[] {nxt, depth+1});
                    visited[nxt] = true; 
                } 
            }
        
        }

        return -1;
    }
}
