package lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/155652

public class 둘만의암호 {
    // ascii : a : 97 ~ z : 122
    public String solution(String s, String skip, int index) {
        String answer = "";

        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            int count = 0;
            while (count < index) {
                c += 1;
                if (c > 122)
                    c = 97;
                if (!skip.contains(String.valueOf(c)))
                    count++;
            }
            answer += String.valueOf(c);
        }
        return answer;
    }
}
