package backjoon.silver.lv1;

import java.util.Scanner;

public class 소수_팰린드롬_1747 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] arr = new int[2000001];
        for (int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        for (int i=2; i<Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) continue;
            for (int j=i*2; j<arr.length; j+=i) {
                arr[j] = 0;
            }
        }

        int answer = 0;
        for (int i=N; i<arr.length; i++) {
            if (arr[i] != 0) {
                if (isPalidrom(arr[i])) {
                    answer = arr[i];
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isPalidrom(int n) {
        String s = String.valueOf(n);
        char[] charArr = s.toCharArray();

        for (int i=0; i<charArr.length/2; i++) {
            if (charArr[i] != charArr[charArr.length-i-1]) return false;
        }

        return true;
    }
}
