package 자료구조;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 위상정렬 {
    public static void main(String[] args) {
        int n = 10;

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDeg = new int[n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            for (int nxt : graph[cur]) {
                inDeg[nxt]--;
                if (inDeg[nxt] == 0) {
                    queue.add(nxt);
                }
            }
        }

        for (int node : result) {
            System.out.println(node + " ");
        }
    }
}
