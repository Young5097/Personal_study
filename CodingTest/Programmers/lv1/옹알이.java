package lv1;

public class 옹알이 {
    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;

            String[] words = new String[] { "aya", "ye", "woo", "ma" };

            for (String bab : babbling) {
                String lastWord = ""; // 마지막 단어 (중복체크)
                String tempBad = bab; // word가 포함되면, substring으로 자름

                while (tempBad.length() > 0) {
                    boolean isPossible = false; // 옹알이 조합이 불가능한 경우 break를 위한 플래그

                    for (String word : words) {
                        if (tempBad.startsWith(word)) { // 특정 옹알이로 시작하는지

                            if (word.equals(lastWord))
                                break; // 반복체크

                            tempBad = tempBad.substring(word.length());
                            lastWord = word;
                            isPossible = true;
                            break;
                        }
                    }

                    if (!isPossible)
                        break; // 특정옹알이로 시작하지 않는다면 해당 bab는 불가능
                }

                if (tempBad.length() == 0)
                    answer++;
            }
            return answer;
        }
    }
}
