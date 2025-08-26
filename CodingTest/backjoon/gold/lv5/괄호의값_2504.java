package backjoon.gold.lv5;

/*
 * https://www.acmicpc.net/problem/2504
 * 
 * 괄호와 숫자를 모두 스택에 넣음
 * - 괄호가 닫히면 숫자로 변경 후, 상황에 따라 계산
 * - 괄호가 닫히지 않은 경우 0 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호의값_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Object> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                // 스택 상단의 숫자값을 저장
                int tmp = 0;
                boolean isMatched = false;

                // 괄호가 닫히기 전, 같은 레벨의 숫자들만 더함
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    tmp += (Integer) stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() instanceof Character) {
                    char top = (Character) stack.peek();
                    if (c == ')' && top == '(') {
                        stack.pop();
                        if (tmp == 0) {
                            stack.push(2);
                        } else {
                            stack.push(tmp * 2);
                        }
                        isMatched = true;
                    } else if (c == ']' && top == '[') {
                        stack.pop();
                        if (tmp == 0) {
                            stack.push(3);
                        } else {
                            stack.push(tmp * 3);
                        }
                        isMatched = true;
                    }
                }

                if (!isMatched) { // 괄호가
                    System.out.println(0);
                    return;
                }
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() instanceof Integer) {
                result += (Integer) stack.pop();
            } else { // 괄호가 남아있는 경우
                System.out.println(0);
                return;
            }
        }

        System.out.println(result);
    }
}