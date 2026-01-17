package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될테야_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());   
        for (int t=0; t<tc; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] apt = new int[k+1][n+1];
            
            for (int i=1; i<=n; i++) {
                apt[0][i] = i;
            }

            for (int f=1; f<=k; f++) {
                for (int h=1; h<=n; h++) {
                    apt[f][h] = apt[f][h-1] + apt[f-1][h];
                }
            }

            System.out.println(apt[k][n]);
        }
    }
}
