package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기_2751_mergeSorted {
    static int[] arr;
    static int[] new_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        new_arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        merge_sort(0, n);

        StringBuilder sb =new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void merge_sort(int start, int end) {
        if (start+1 == end) return;
        int mid = (start+end)/2;
        merge_sort(start, mid);
        merge_sort(mid, end);
        merge(start, end);
    }

    public static void merge(int start, int end) { // ex) 2,3,4,5 / start=2, end=6
        int mid = (start+end)/2; // mid=4
        int left_idx = start;
        int right_idx = mid;
        for (int i=start; i<end; i++) {
            if (right_idx == end) { // 오른쪽 끝(end)이 6이 됐을때(5를 처리한 후, right_idx++ = 6)
                new_arr[i] = arr[left_idx++];
            } else if (left_idx == mid) {
                new_arr[i] = arr[right_idx++]; // 왼쪽 끝(mid)이 4이 됐을때(3를 처리한 후, left_idx++ = 4)
            } else if (arr[left_idx] <= arr[right_idx]) {
                new_arr[i] = arr[left_idx++];
            } else {
                new_arr[i] = arr[right_idx++];
            }
        }
        for (int i = start; i < end; i++) {
            arr[i] = new_arr[i];
        }
    }
}
