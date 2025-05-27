import java.util.*;

public class 땅따먹기 {//

    class Solution {
        int solution(int[][] land) {
            int len = land.length;
            int[][] score = new int[len][4];

            // 첫행은 고정하고, 행을 내려가면서 최대값을 구함
            for (int i = 0; i < 4; i++) {
                score[0][i] = land[0][i];
            }

            for (int i = 1; i < len; i++) { // 계산할 행
                for (int j = 0; j < 4; j++) { // 계산할 열
                    int max = 0;
                    for (int k = 0; k < 4; k++) { // 이전 행에서 현재 열을 제외한 최대값
                        if (j != k) {
                            max = Math.max(max, score[i - 1][k]);
                        }
                    }
                    score[i][j] = max + land[i][j];
                }
            }

            // 마지막 행에서 최대값 찾기
            int answer = 0;
            for (int i = 0; i < 4; i++) {
                answer = Math.max(answer, score[len - 1][i]);
            }

            return answer;
        }
    }
}
