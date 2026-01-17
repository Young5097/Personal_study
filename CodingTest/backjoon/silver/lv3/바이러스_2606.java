package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class 바이러스_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comp = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[comp+1];
        for (int i=0; i<=comp; i++) {
            graph[i] = new ArrayList<>();
        } 
        int n = Integer.parseInt(br.readLine());
        for (int i=1; i<=n; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[comp + 1];
        Stack<Integer> stack = new Stack<>();
        visited[1] = true;
        stack.add(1);

        int count = 0;
        while(!stack.isEmpty()) {
            int cur = stack.pop();

            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    stack.add(nxt);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
