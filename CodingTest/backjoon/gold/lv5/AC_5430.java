package backjoon.gold.lv5;

import java.io.*;
import java.util.*;

public class AC_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            
            String s_arr = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] arr = s_arr.substring(1, s_arr.length()-1).split(",");
                for (String s : arr) {
                    deque.add(Integer.parseInt(s));
                }
            }

            boolean errorFlag = false;
            boolean reversed = false;

            for (int i=0; i<commands.length; i++) {
                if (commands[i] == 'R') {
                    reversed = !reversed;
                } else {
                    if (deque.size() == 0) {
                        errorFlag = true;
                        break;
                    }

                    if (!reversed) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            if (errorFlag) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                if (reversed) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeLast());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeFirst());
                        if (!deque.isEmpty()) {
                            sb.append(",");
                        }
                    }
                }
                
                sb.append("]");
                System.out.println(sb);
            }
        } 
    }
}