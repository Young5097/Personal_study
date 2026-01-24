package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 패션왕_9357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i=0; i<n; i++) {
                String[] str = br.readLine().split(" ");
                map.put(str[1], map.getOrDefault(str[1], 1) + 1);
            }

            int result = 1;
            for (int count : map.values()) {
                result *= count;
            }

            System.out.println(result-1);
        }
    }
}