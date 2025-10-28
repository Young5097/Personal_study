package backjoon.gold.lv4;

import java.util.*;

public class 물통_2251 {
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};

    static boolean[][] AB_arr;
    static boolean[] C_arr; // C의 용량
    static int[] capacity; // 통들의 용량

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        capacity = new int[3]; 
        AB_arr = new boolean[201][201];
        C_arr = new boolean[201];
        capacity[0] = Integer.parseInt(st.nextToken());
        capacity[1] = Integer.parseInt(st.nextToken());
        capacity[2] = Integer.parseInt(st.nextToken());

        bfs();

        for (int i=0; i<=capacity[2]; i++) {
            if (C_arr[i]) System.out.print(i + " ");
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, capacity[2]});
        AB_arr[0][0] = true;
        C_arr[capacity[2]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int A = now[0];
            int B = now[1];
            int C = now[2];

            if (A == 0) {
                C_arr[C] = true;
            }

            for (int i=0; i<6; i++) {
                int[] next = new int[] {A, B, C};

                int from = sender[i];
                int to = receiver[i];

                // 보낼 물통 안의 물, 받을 물통의 현재 물양 -> 빈 공간만큼만 받을 수 있기 때문에
                int move = Math.min(next[from], capacity[to]-next[to]);
                next[from] -= move;
                next[to] += move;

                if (!AB_arr[next[0]][next[1]]) {
                    AB_arr[next[0]][next[1]] = true;
                    queue.add(next);
                }
            }
        }
    }
}
