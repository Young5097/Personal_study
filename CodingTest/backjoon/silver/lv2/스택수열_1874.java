package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            int cur_num = arr[i];
            if (cur_num >= num) {
                while (cur_num >= num) {
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                int pop_num = stack.pop();

                // 앞으로 pop 되어야할 값들이 스택에 들어있는데, 맨위에꺼랑 맞지 않아서 pop 해버리면 이후 로직이 불가능해짐
                if (pop_num != cur_num) { 
                    System.out.println("NO");
                    result = false;
                    break;
                }

                sb.append("-").append("\n");
            }
        }

        if (result) System.out.println(sb);
    }
}
