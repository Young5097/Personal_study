package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class 카드_11652_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[] cards = new long[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }

        Map<Long, Integer> map = new HashMap<>(); 
        for (long card : cards) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int maxCount = Integer.MIN_VALUE;
        long result = 0;
        for (Long card : map.keySet()) {
            int count = map.get(card);
            if (maxCount < count || (count == maxCount && result > card)) {
                maxCount = count;
                result = card;
            } 
        }

        System.out.println(result);
    }
}
