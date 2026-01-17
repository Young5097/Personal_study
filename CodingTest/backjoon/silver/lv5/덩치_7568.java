package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 덩치_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] hw = new int[n][2];
        for (int i=0; i<n; i++) {
            String[] h_w = br.readLine().split(" ");
            hw[i][0] = Integer.parseInt(h_w[0]);
            hw[i][1] = Integer.parseInt(h_w[1]);
        }

        // 현재 사람보다 덩치가 큰 사람 갯수 == 순위
        int[] moreBig = new int[n];
        for (int i=0; i<n; i++) {
            int countBig = 0;
            for (int j=0; j<n; j++) {
                if (i==j) continue;
                if (hw[i][0] < hw[j][0] && hw[i][1] < hw[j][1]) {
                    countBig++;
                }
            }
            moreBig[i] = countBig;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(moreBig[i] + 1).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

