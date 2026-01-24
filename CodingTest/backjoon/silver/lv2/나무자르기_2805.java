package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나무자르기_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st1 = br.readLine().split(" ");
        int n = Integer.parseInt(st1[0]);
        int want = Integer.parseInt(st1[1]);

        int[] trees = new int[n];
        int maxHei  = Integer.MIN_VALUE;

        String[] st2 = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            int num  = Integer.parseInt(st2[i]);
            trees[i] = num;
            maxHei = Math.max(maxHei, num);
        }

        int st = 0;
        int en = maxHei;
        long answer = 0;

        while (st <= en) {
            int mid = (st+en)/2;

            long sum = 0;
            for (int i=0; i<n; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }

            if (sum >= want) {
                answer = mid;
                st = mid + 1;
            } else {
                en = mid - 1;
            }
        }

        System.out.println(answer);
    }
}