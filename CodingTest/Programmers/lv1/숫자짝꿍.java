import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/131128

class 숫자짝꿍 {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char c : X.toCharArray()) {
            // countX[Integer.parseInt(String.valueOf(c))]++;
            countX[c - '0']++; // ASCII 코드 계산
        }
        for (char c : Y.toCharArray()) {
            // countY[Integer.parseInt(String.valueOf(c))]++;
            countY[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) { // 내림차순으로 더함
            int minCount = Math.min(countX[i], countY[i]);
            for (int j = 0; j < minCount; j++) {
                sb.append(i);
            }
        }

        String result = sb.toString();
        // Collections.sort(result, Collections.reverseOrder())

        if (result.length() == 0)
            return "-1";
        if (result.charAt(0) == '0')
            return "0";

        return result;
    }
}