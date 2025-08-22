package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;

public class 에디터_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            leftStack.push(str.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            if (c == 'L') {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (c == 'D') {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if (c == 'B') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else if (c == 'P') {
                char x = command.charAt(2);
                leftStack.push(x);
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public LinkedList<Character> fail_solution(String str, String[] commands) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        int cursor = list.size();

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            if (command.equals("L")) {
                if (cursor > 0) {
                    cursor--;
                }
            } else if (command.equals("D")) {
                if (cursor < list.size()) {
                    cursor++;
                }
            } else if (command.equals("B")) {
                if (cursor > 0) {
                    list.remove(cursor - 1);
                    cursor--;
                }
            } else if (command.startsWith("P")) {
                String[] command_s = command.split(" ");
                char c = command_s[1].charAt(0);
                list.add(cursor, c);
                cursor++;
            }
        }
        return list;
    }
}
