package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/10799
 * 
 * 스택에 괄호를 넣으면서 괄호가 닫힐때, 레이저인지 쇠막대기인지 확인
 * - 레이저인 경우, 스택에 남아있는 쇠막대기 개수만큼 조각 추가
 * - 쇠막대기 끝인 경우, 조각 1개 추가
 */

public class 쇠막대기_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();

                if (input.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
