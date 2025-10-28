package backjoon.gold.lv5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class 거의소수_1456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[] arr = new long[10000001];
        for (int i=2; i<arr.length; i++) {
            arr[i] = i;
        }
        
        for (int i=2; i<Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) continue;
            for (int j=i+i; j<arr.length; j+=i) {
                arr[j] = 0; 
            }
        }

        int count = 0;
        for (int i=2; i<arr.length; i++) {
            if (arr[i] == 0) continue;
            long tmp = arr[i] * arr[i];
            while (tmp <= B) {
                if (tmp >= A) count++;
                if (tmp > B / arr[i]) break; // 다음 제곱이 오버플로우인지 확인 => tmp*arr[i]/arr[i] > B/arr[i] -> tmp > B / arr[i]
                tmp *= arr[i];
            }
        }
        System.out.println(count);
    }
}
