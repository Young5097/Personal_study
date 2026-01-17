package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 통계학_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }

        Arrays.sort(numbers);

        // 1. 평균
        int avg = (int) Math.round((double) sum / N);
        System.out.println(avg);

        // 2. 중앙값
        int median = N/2;
        System.out.println(numbers[median]);

        // 3. 최빈값
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            freqMap.put(numbers[i], freqMap.getOrDefault(numbers[i], 0) + 1);
        }

        int maxFreq = 0;
        for (int value : freqMap.values()) {
            maxFreq = Math.max(maxFreq, value);
        }

        int freqAnswer = Integer.MIN_VALUE;
        int count = 0;
        for (int num : numbers) { // Map은 순서를 보장하지 않음. 오름차순으로 정렬된 numbers 배열 사용
            if (maxFreq == freqMap.get(num)) {
                if (freqAnswer != num) {
                    freqAnswer = num;
                    count++;
                    if (count == 2) {
                        break;
                    }
                }
            }
        }
        System.out.println(freqAnswer);
        
        // 4. 범위
        int range = numbers[N-1] - numbers[0];
        System.out.println(range);
    }
}