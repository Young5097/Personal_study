package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 집합_11723 {
    static Set<Integer> set;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        set = new HashSet<>();
        sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            
            if (command.equals("add")) {
                add(Integer.parseInt(input[1]));
            } else if (command.equals("remove")) {
                remove(Integer.parseInt(input[1]));
            } else if (command.equals("check")) {
                check(Integer.parseInt(input[1]));
            } else if (command.equals("toggle")) {
                toggle(Integer.parseInt(input[1]));
            } else if (command.equals("all")) {
                all();
            } else if (command.equals("empty")) {
                empty();
            }
        }

        System.out.println(sb.toString());
    }

    public static void add(int n) {
        set.add(n);
    }
    public static void remove(int n) {
        set.remove(n);
    }
    public static void check(int n) {
        if (set.contains(n)) {
            sb.append("1").append("\n");
        } else {
            sb.append("0").append("\n");
        }
    }
    public static void toggle (int n) {
        if (set.contains(n)) {
            set.remove(n);
        } else {
            set.add(n);
        }
    }
    public static void all() {
        set.clear();
        for (int i=1;i<=20;i++) {
            set.add(i);
        }
    }
    public static void empty() {
        set.clear();
    }
}
