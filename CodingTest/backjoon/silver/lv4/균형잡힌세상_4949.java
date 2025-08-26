package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/4949
 */

public class 균형잡힌세상_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (true) {
            input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            if (input.equals(".")) {
                break;
            }

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }

                    char top = stack.peek();

                    if (c == ')' && top == '(') {
                        stack.pop();
                    } else if (c == ']' && top == '[') {
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }

            // (,[ 가 남아있는 경우 고려
            if (isBalanced && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
