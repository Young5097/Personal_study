package lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/140108

public class 문자열나누기 {
    public int solution(String s) {
        int answer = 0;
        int index = 0;

        while (index < s.length()) {
            char x = s.charAt(index);
            int xCount = 1; // 첫 번째 문자(x) 카운트
            int otherCount = 0;
            index++;

            // x와 x가 아닌 글자들의 횟수를 셈
            while (index < s.length()) {
                if (s.charAt(index) == x) {
                    xCount++;
                } else {
                    otherCount++;
                }

                // 두 횟수가 같아지면 분리
                if (xCount == otherCount) {
                    answer++;
                    index++;
                    break;
                }

                index++;
            }

            // 더 이상 읽을 글자가 없거나 두 횟수가 다른 상태에서 끝나면 분리
            if (index >= s.length() && xCount != otherCount) {
                answer++;
            }
        }

        return answer;
    }
}
