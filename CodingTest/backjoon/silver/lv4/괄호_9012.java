package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            for (char c : str.toCharArray()) {
                if (c == '(') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    } 

                    char pre = stack.peek();
                    if (pre == '(') {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
