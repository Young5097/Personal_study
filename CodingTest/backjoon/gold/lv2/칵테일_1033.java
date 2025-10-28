package backjoon.gold.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 칵테일_1033 {

    static class Node {
        int b;
        int p;
        int q;
        public Node(int b, int p, int q) {
            this.b=b; 
            this.p=p; 
            this.q=q;
        } 
    }

    static long amount_lcm; // 모든 재료비율의 최소공배수
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static long[] amounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N];
        for (int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }

        amount_lcm = 1; // 모든 재료비율의 최소공배수의 곱을 초기질량으로 사용
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
        
            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));
            amount_lcm *= lcm(p, q);
        }

        visited = new boolean[N];
        amounts = new long[N];

        // 각 재료들의 질량 업데이트(최소공배수는 아님)
        amounts[0] = amount_lcm;
        dfs(0);

        // 질량들의 최대공약수 구하기
        long amount_gcd = amounts[0];
        for (int i=1; i<N; i++) {
            amount_gcd = gcd(amount_gcd, amounts[i]);
        }

        /*
            각 재료의 질량/질량들의 gcd 출력
            질량들은 최소값들이 아님. 
            따라서 질량들의 최대공약수(d>1)가 있다면, 해당 질량값들은 wei/d를 통해 최소한으로 만들 수 있음
         */
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(amounts[i]/amount_gcd).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int cur) {
        visited[cur] = true;

        for (Node nxt_node : graph[cur]) {
            int nxt = nxt_node.b;
            if (!visited[nxt]) {
                amounts[nxt] = amounts[cur] / nxt_node.p * nxt_node.q;
                dfs(nxt);
            }
        }
    }

    static long gcd(long a, long b) { 
        if (b==0) return a;
        return gcd(b, a%b);
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}

