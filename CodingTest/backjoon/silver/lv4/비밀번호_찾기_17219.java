package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 비밀번호_찾기_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        Map<String, String> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            map.put(data[0], data[1]);
        }
        
        for (int i = 0; i < m; i++) {
            System.out.println(map.get(br.readLine()));
        }
        
        br.close();
    }
}