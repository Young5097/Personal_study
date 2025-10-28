package backjoon.gold.lv5;

import java.util.Scanner;

public class 집합의표현_1717 {
    static int[] parents;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 원소의 개수 (0 ~ n)
        int m = sc.nextInt();  // 연산의 개수
        
        parents = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int command = sc.nextInt();  // 0: 합집합, 1: 같은 집합 확인
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if (command == 0) {
                // a가 포함된 집합과 b가 포함된 집합 합치기
                int a_p = find(a);
                int b_p = find(b);
                if (a_p != b_p) {
                    parents[b_p] = a_p;
                }
            } else {
                // a와 b가 같은 집합인지 확인 → YES/NO 출력
                int a_p = find(a);
                int b_p = find(b);
                if (a_p == b_p) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        } else {
            return parents[x] = find(parents[x]); // 경로압축
        }
    }
}
