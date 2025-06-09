import java.util.*;

class 큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;

        /*
         * 15123526(8) 3
         * 1) (1번째부터)151235/26 -> 123526 => 5(2번째)
         * 2) (3번째부터)12352/6 -> 56 => 5(7번째)
         * 3) 26 -> 6 => 6(-1번째)
         * 답은 556
         */

        for (int i = 0; i < number.length() - k; i++) {
            char max = '0';
            // 반복 : number.length() - (number.length() - i - k - 1)
            // 즉, 현재 idx부터 체크할 수 있는 수의 갯수
            for (int j = idx; j < i + k + 1; j++) {
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    idx = j + 1; // max로 선정된 다음 자리부터 찾기 위해
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}