package backjoon.silver.lv2;

import java.util.Scanner;

public class 잃어버린괄호_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        String[] exp_split = exp.split("\\-");

        int answer = 0;
        for (int i=0; i<exp_split.length; i++) {
            int n = sum(exp_split[i]);
            if (i==0) {
                answer += n;
            } else {
                answer -= n;
            }
        }

        System.out.println(answer);
    }

    static int sum(String string) {
        String[] s_split = string.split("\\+");

        int sum = 0;
        for (String s : s_split) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
