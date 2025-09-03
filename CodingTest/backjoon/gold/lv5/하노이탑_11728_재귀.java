package backjoon.gold.lv5;

/*
귀납적으로 생각!

n = k 일때 정상이면 n = k+1 일때도 동적하고 n = k + x 일때도 잘 동작해야함
따라서 n을 옮길려면 n-1을 2, n을 3, n-1을 3으로 옮기면 됨
이후에도 n-2를 2, n-1을 3, n-2를 3으로 옮기면 된다

https://www.acmicpc.net/problem/11729
*/  


import java.util.Scanner;

public class 하노이탑_11728_재귀 {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        hanoi(n, 1, 3, 2);
        System.out.println(count);
        System.out.print(sb.toString());
    }

    public static void hanoi(int n, int from, int to, int temp) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }

        hanoi(n-1, from, temp, to);
        sb.append(from).append(" ").append(to).append("\n");
        count++;
        hanoi(n-1, temp, to, from); // if문에서 return 하게되니 sb와 count를 계산 X
    }
}
