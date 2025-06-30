import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265

public class 케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int t : topping) {
            rightMap.put(t, rightMap.getOrDefault(t, 0) + 1);
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            leftMap.put(t, leftMap.getOrDefault(t, 0) + 1);

            rightMap.put(t, rightMap.getOrDefault(t, 0) - 1);
            if (rightMap.get(t) == 0) {
                rightMap.remove(t);
            }

            if (leftMap.size() == rightMap.size()) {
                answer += 1;
            }
        }

        return answer;
    }
}
