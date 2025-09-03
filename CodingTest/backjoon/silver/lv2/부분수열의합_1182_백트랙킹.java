package backjoon.silver.lv2;

/*
 * https://www.acmicpc.net/problem/1182
 * 
 * 부분수열 -> {1,2} = {}, {1}, {2}, {1,2}
 * 부분수열의 갯수는 2^n
 * 문제에서는 공집합은 제외이므로 2^n
 */

import java.util.Scanner;

public class 부분수열의합_1182_백트랙킹 {
    static int n, s, count = 0;
    static int[] arr = new int[20];
    static boolean[] visited = new boolean[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        String[] numbers = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        backtracking(0, 0, 0);
        System.out.println(count);
    }
    
    public static void backtracking(int index, int sum, int count) {
        if (index == n) {
            if (sum == s && count > 0) {
                count++;
            }
            return;
        }
        backtracking(index+1, sum, count);
        backtracking(index+1, sum+arr[index], count++);
    }

    public static void backtracking2(int index) {
        if (index == n) {
            int sum = 0;
            boolean isEmpty = true;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                    isEmpty = false;
                }
            }

            if (!isEmpty && sum == s) {
                count++;
            }
            return;
        }

        // 현재 원소를 포함하지 않는 경우
        visited[index] = false;
        backtracking2(index + 1);

        // 현재 원소를 포함하는 경우  
        visited[index] = true;
        backtracking2(index + 1);
        visited[index] = false; 
    }
}
