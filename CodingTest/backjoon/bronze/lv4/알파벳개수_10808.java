package backjoon.bronze.lv4;

import java.util.Scanner;

public class 알파벳개수_10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int solution2(int[] arr, int n) {
        int[] occur = new int[101];
        for (int i = 0; i < n; i++) {
            if (occur[100 - arr[i]] == 1) {
                return 1;
            }
            occur[100 - arr[i]] = 1;
        }
        return 0;
    }
}
