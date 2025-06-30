import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512

public class 모음사전_DFS {
    class Solution {
        ArrayList<String> dict = new ArrayList<>();
        String std = "AEIOU";

        public void init(int num, int cnt, String cmd) {
            // num : 만들 단어 길이
            // cnt : 현재 만든 단어 길이
            // cmd: 현재까지 만든 단어

            if (num == cnt) { // 목표 길이에 도달하면 리스트에 추가
                dict.add(cmd);
                return;
            }

            // 각 모음(A, E, I, O, U) 추가
            for (int i = 0; i < 5; i++) {
                init(num, cnt + 1, cmd + Character.toString(std.charAt(i)));
            }
        }

        public int solution(String word) {
            int answer = 0;

            // 1~5글자 모든 단어 생성
            for (int i = 1; i <= 5; i++) {
                init(i, 0, "");
            }

            Collections.sort(dict);
            int idx = 1;

            for (String s : dict) {
                if (s.equals(word)) {
                    answer = idx;
                    return answer;
                }
                idx++;
            }

            return answer;
        }

    }
}

/*
 * AAAAE를 찾는 과정
 * init(1, 0, "") 호출
 * ├── A 추가: init(1, 1, "A") → dict에 "A" 추가
 * ├── E 추가: init(1, 1, "E") → dict에 "E" 추가
 * ├── I 추가: init(1, 1, "I") → dict에 "I" 추가
 * ├── O 추가: init(1, 1, "O") → dict에 "O" 추가
 * └── U 추가: init(1, 1, "U") → dict에 "U" 추가
 * 
 * init(2, 0, "") 호출
 * ├── A 추가: init(2, 1, "A")
 * │ ├── A 추가: init(2, 2, "AA") → dict에 "AA" 추가
 * │ ├── E 추가: init(2, 2, "AE") → dict에 "AE" 추가
 * │ ├── I 추가: init(2, 2, "AI") → dict에 "AI" 추가
 * │ ├── O 추가: init(2, 2, "AO") → dict에 "AO" 추가
 * │ └── U 추가: init(2, 2, "AU") → dict에 "AU" 추가
 * ├── B 추가: init(2, 1, "B")
 * │ ├── A 추가: init(2, 2, "BA") → dict에 "BA" 추가
 * │ ├── E 추가: init(2, 2, "BE") → dict에 "BE" 추가
 * │ ├── I 추가: init(2, 2, "BI") → dict에 "BI" 추가
 * │ ├── O 추가: init(2, 2, "BO") → dict에 "BO" 추가
 * │ └── U 추가: init(2, 2, "BU") → dict에 "BU" 추가
 * 
 * ...
 * 
 * init(5, 0, "") 호출
 * ├── A 추가: init(5, 1, "A")
 * │ ├── A 추가: init(5, 2, "AA")
 * │ │ ├── A 추가: init(5, 3, "AAA")
 * │ │ │ ├── A 추가: init(5, 4, "AAAA")
 * │ │ │ │ ├── A 추가: init(5, 5, "AAAAA") → dict에 "AAAAA" 추가
 * │ │ │ │ ├── E 추가: init(5, 5, "AAAAE") → dict에 "AAAAE" 추가 (찾는 단어)
 * │ │ │ │ ├── I 추가: init(5, 5, "AAAAI") → dict에 "AAAAI" 추가
 * │ │ │ │ ├── O 추가: init(5, 5, "AAAAO") → dict에 "AAAAO" 추가
 * │ │ │ │ └── U 추가: init(5, 5, "AAAAU") → dict에 "AAAAU" 추가
 */