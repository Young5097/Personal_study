package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나이순정렬_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][3];
        for (int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            arr[i][0] = str[0];
            arr[i][1] = str[1];
            arr[i][2] = String.valueOf(i);
        }

        Arrays.sort(arr, (a, b) -> {
            if (Integer.parseInt(a[0]) != Integer.parseInt(b[0])) {
                return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
            }
            return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
        });

        for (int i=0; i<n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
