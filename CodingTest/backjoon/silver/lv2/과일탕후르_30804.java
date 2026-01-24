package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 좌우에서 얼마만큼 잘라내고 남은게 2종류만 남으면서 길이가 최대가 되어야함
// fruits는 탕후르에 끼워진 과일들의 종류가 적혀있음 ex) 1 2 2 5 1 5 5 3 4 5 1
public class 과일탕후르_30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] fruits = new int[n];
        String[] st = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            fruits[i] = Integer.parseInt(st[i]);
        }
        
        // 투포인트 알고리즘
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            // 현재 종류가 2종류보다 많으면
            while (map.size() > 2) {
                int leftFruit = fruits[left];
                if (map.get(leftFruit) == 1) {
                    map.remove(leftFruit);
                } else {
                    map.put(leftFruit, map.get(leftFruit) - 1);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
    }    
}
