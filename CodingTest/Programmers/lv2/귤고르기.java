/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=java
 * 
 * 주의할 점!!
 * - 입출력 예시를 보면 k가 2인데 크기가 4인 귤이 4개 있으면?
 * - 이 경우에 result는 1이다. 
 * - 4개 중에 2개를 담으면 되니깐
 */

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizeZip = new HashMap<>();
        for (int size : tangerine) {
            if (sizeZip.containsKey(size)) {
                sizeZip.put(size, sizeZip.get(size) + 1);
            } else {
                sizeZip.put(size, 1);
            }
        }

        List<Integer> counts = new ArrayList<>(sizeZip.values());
        Collections.sort(counts, Collections.reverseOrder());

        System.out.println(counts.toString());

        int result = 0;
        for (int count : counts) {
            k -= count;
            result++;
            if (k <= 0) {
                break;
            }
        }

        return result;
    }
}
