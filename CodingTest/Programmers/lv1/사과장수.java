package lv1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/135808

public class 사과장수 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        // 1-1. 래퍼 배열 만들기 : int[]는 Comparator 불가
        // Integer[] scoreArr = new Integer[score.length];
        // for (int i = 0; i < score.length; i++) {
        // scoreArr[i] = score[i];
        // }

        // 1-2. 래퍼 배열 만들기
        // : boxed()::래퍼 클래스로 변환
        // toArray(Integer[]::new)::Integer[] 배열로 변환, 앞 스트림에서 넘어온 배열을 그대로 참조된 생성자로 생성함
        // -> Interger[] r = new Integer[`스트림 된 배열의 값들`]
        Integer[] scoreArr = Arrays.stream(score).boxed().toArray(Integer[]::new);

        // 2. 내림차순 정렬
        Arrays.sort(scoreArr, (a, b) -> b - a);

        // 3. 상자 만들기
        for (int i = 0; i <= scoreArr.length - m; i += m) {
            int minScore = scoreArr[i + m - 1];
            answer += minScore * m;
        }

        return answer;
    }
}
