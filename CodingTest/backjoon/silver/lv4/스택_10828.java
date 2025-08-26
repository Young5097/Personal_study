package backjoon.silver.lv4;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/10828
 */

public class 스택_10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] commands = new String[n];
        for (int i = 0; i < n; i++) {
            commands[i] = scanner.nextLine();
        }

        Stack stack = new 스택_10828().new Stack(n);

        for (int i = 0; i < n; i++) {
            String command = commands[i];
            if (command.startsWith("push")) {
                String[] parts = command.split(" ");
                int x = Integer.parseInt(parts[1]);
                stack.push(x);
            } else if (command.equals("pop")) {
                System.out.println(stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.empty());
            } else if (command.equals("top")) {
                System.out.println(stack.top());
            }
        }
    }

    class Stack {
        private int[] stack;
        private int top;

        public Stack(int n) {
            stack = new int[n];
            top = -1;
        }

        public void push(int x) {
            stack[++top] = x;
        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            return stack[top--];
        }

        public int size() {
            return top + 1;
        }

        public int empty() {
            if (top == -1) {
                return 1;
            }

            return 0;
        }

        public int top() {
            if (top == -1) {
                return -1;
            }
            return stack[top];
        }
    }
}