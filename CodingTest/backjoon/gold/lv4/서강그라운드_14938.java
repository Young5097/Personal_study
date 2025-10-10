package backjoon.gold.lv4;

import java.util.*;
import java.io.*;

public class 서강그라운드_14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 지역 개수
        int m = Integer.parseInt(st.nextToken());  // 수색 범위
        int r = Integer.parseInt(st.nextToken());  // 길의 개수
        
        // 각 지역의 아이템 개수
        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = 10000000;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());  
            
            dist[a][b] = l;
            dist[b][a] = l;
        }

        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }                
            }
        } 
        
        int maxItem = 0;
        for (int i=1; i<=n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= m) {
                     sum += items[j];
                }
            }
            maxItem = Math.max(maxItem, sum);
        }

        System.out.println(maxItem);
    }
}
