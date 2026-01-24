package backjoon.silver.lv4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 듣보잡_1764 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        Set<String> a = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextLine());
        }

        for (int i = 0; i < m; i++) {
            String name = scanner.nextLine();
            if (a.contains(name)) {  // O(1)
                result.add(name);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }

        scanner.close();
    }
}