//https://school.programmers.co.kr/learn/courses/30/lessons/17687

public class N진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder allNums = new StringBuilder();
        int num = 0;

        while (allNums.length() < (t * m)) {
            String numStr = Integer.toString(num, n).toUpperCase();
            allNums.append(numStr);
            num++;
        }

        for (int i = 0; i < t; i++) {
            int idx = (p - 1) + (m * i);
            answer.append(allNums.charAt(idx));
        }

        return answer.toString();
    }
}
