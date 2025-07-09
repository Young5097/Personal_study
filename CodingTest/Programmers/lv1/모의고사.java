package lv1;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=java

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];

        // 각 학생의 패턴 정의
        int[] pattern1 = { 1, 2, 3, 4, 5 };
        int[] pattern2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] pattern3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        // 점수 계산
        for (int i = 0; i < answers.length; i++) {
            if (pattern1[i % pattern1.length] == answers[i])
                scores[0]++;
            if (pattern2[i % pattern2.length] == answers[i])
                scores[1]++;
            if (pattern3[i % pattern3.length] == answers[i])
                scores[2]++;
        }

        // 최대 점수 찾기
        int maxScore = Math.max(Math.max(scores[0], scores[1]), scores[2]);

        // 최고 점수 학생 수 계산
        int count = 0;
        for (int score : scores) {
            if (score == maxScore)
                count++;
        }

        // 결과 배열 생성 및 채우기
        int[] result = new int[count];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                result[idx++] = i + 1;
            }
        }

        return result;
    }
}
