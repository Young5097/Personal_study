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
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.offer(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int current = pos[0];
            int depth = pos[1];

            if (current == target) {
                return depth;
            }

            if (current - 1 >= 0 && !visited[current-1]) {
                queue.offer(new int[] {current-1, depth+1});
                visited[current-1] = true;
            }
            if (current + 1 < 100001 && !visited[current+1]) {
                queue.offer(new int[] {current+1, depth+1});
                visited[current+1] = true;
            }
            if (current * 2 < 100001 && !visited[current*2]) {
                queue.offer(new int[] {current*2, depth+1});
                visited[current*2] = true;
            }
        }

        return -1;
    }
}
