import java.util.HashMap;
import java.util.Map;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 원하는 제품과 수량을 Map으로 저장
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 10일 연속으로 확인
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> tempMap = new HashMap<>(wantMap);
            boolean isValid = true;

            // 10일 동안의 할인 제품 확인
            for (int j = i; j < i + 10; j++) {
                String product = discount[j];
                if (tempMap.containsKey(product)) {
                    tempMap.put(product, tempMap.get(product) - 1);
                    if (tempMap.get(product) == 0) {
                        tempMap.remove(product);
                    }
                }
            }

            // 모든 제품을 원하는 수량만큼 구매할 수 있는지 확인
            if (tempMap.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
