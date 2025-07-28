package lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/160586

import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> keyMap = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char cKey = key.charAt(i);

                if (!keyMap.containsKey(cKey) || keyMap.get(cKey) > i) {
                    keyMap.put(cKey, i + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            char[] tgArr = targets[i].toCharArray();
            int count = 0;
            boolean isPossible = true;

            for (char c : tgArr) {
                if (keyMap.containsKey(c)) {
                    count += keyMap.get(c);
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                answer[i] = count;
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }
}
