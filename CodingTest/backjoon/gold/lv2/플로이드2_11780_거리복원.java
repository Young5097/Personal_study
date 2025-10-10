package backjoon.gold.lv2;

import java.util.*;
import java.io.*;

public class 플로이드2_11780_거리복원 {
    static int MAX = 100000000; // n*m이 거리 최댓값이므로(불가능하지만 가정해서)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n+1][n+1];
        int[][] nxt = new int[n+1][n+1]; // 경유지를 기록

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                if (i==j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = MAX;
                } 
            }
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            dist[a][b] = Math.min(dist[a][b], cost);
            nxt[a][b] = b;
        }

        for (int k=1; k<=n; k++) { // 경유지
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) { // ex) 1-2-3 vs 1-3
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                        nxt[i][j] = nxt[i][k]; // i에서 j로 가려면 먼저 nxt[i][k]로 가야 함. 즉 경유지 기록
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (dist[i][j] == MAX) {
                    sb.append("0 ");
                } else {
                    sb.append(dist[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (dist[i][j] == 0 || dist[i][j] == MAX) {
                    sb.append(0).append("\n");
                } else {
                    List<Integer> path = new ArrayList<>();
                    int cur = i; // 출발지
                    /*
                     * ex) 1 - 3 - 5 - 7
                     * nxt[1][7] = 3, cur = 3
                     * nxt[3][7] = 5, cur = 5
                     * nxt[5][7] = 7, cur = 7
                     * cur == j 이므로 종료
                     */
                    while (cur != j) { 
                        path.add(cur);
                        cur = nxt[cur][j];
                    }
                    path.add(j); // 도착지

                    sb.append(path.size() + " ");
                    for (int p : path) {
                        sb.append(p + " ");
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
