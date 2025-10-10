package backjoon.gold.lv4;

import java.util.*;
import java.io.*;

public class 플로이드_11404 {
    static int MAX = 100000000; // n*m이 거리 최댓값이므로(불가능하지만 가정해서)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n+1][n+1];
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
        }

        for (int k=1; k<=n; k++) { // 경유지
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); // ex) 1-2-3 vs 1-3
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
        System.out.println(sb);
    }
}
