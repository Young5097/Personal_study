package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기5_15688_countingSort {
    static int[] arr;
    static int[] countArr = new int[2000001];
    static int OFFSET = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int num : arr) {
            countArr[num+OFFSET] += 1;
        }

        StringBuilder sb= new StringBuilder();
        for (int i=0; i<countArr.length; i++) {
            if (countArr[i] > 0) {
                while(countArr[i] > 0) {
                    sb.append(i-OFFSET).append("\n");
                    countArr[i]--;
                }
            }
        }
        System.out.println(sb.toString());
    }   
}
