import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/17684

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();

        // 사전 초기화 (A-Z)
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        int nextIndex = 27;
        int i = 0;

        while (i < msg.length()) {
            String w = "";
            String c = "";

            // 현재 위치에서 시작하는 가장 긴 문자열 찾기
            for (int j = i; j < msg.length(); j++) {
                String current = msg.substring(i, j + 1);
                if (dictionary.containsKey(current)) {
                    w = current;
                } else {
                    c = String.valueOf(msg.charAt(j));
                    break;
                }
            }

            // w에 해당하는 색인 번호 출력
            answer.add(dictionary.get(w));

            // w+c를 사전에 등록
            if (i + w.length() < msg.length()) {
                dictionary.put(w + c, nextIndex++);
            }

            i += w.length();
        }

        return answer;
    }
}
