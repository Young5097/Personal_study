// https://school.programmers.co.kr/learn/courses/30/lessons/152996?language=java

class 시소짝궁 {

    // 시소 거리 비율에 따른 무게 비율 (왼쪽 : 오른쪽)
    private final int[][] RATIOS = { { 1, 2 }, { 2, 3 }, { 3, 4 } };

    public long solution(int[] weights) {
        long cnt = 0L;
        long[] wCnt = new long[1001]; // 몸무게별 사람 수 (100 ≤ w ≤ 1000)

        // 몸무게별 사람 수를 카운트
        for (int w : weights) {
            wCnt[w]++;
        }

        // 몸무게가 100부터 1000까지 가능한 조합을 순회
        for (int w = 100; w <= 1000; w++) {
            if (wCnt[w] == 0)
                continue;

            // 같은 몸무게끼리 시소 짝꿍 (1:1 비율)
            cnt += (wCnt[w] - 1) * wCnt[w] / 2;

            // 다른 비율의 시소 짝꿍 탐색 : 자신보다 큰 무게와 비교하므로 중복X
            for (int[] ratio : RATIOS) {
                if (w % ratio[0] != 0)
                    continue; // 몸무게는 모두 정수

                // weight1 * distance1 = weight2 * distance2 -> weight2 = weight1 * distance1 /
                // distance2
                int target = (w / ratio[0]) * ratio[1];

                // 유효 범위 벗어나면 스킵
                if (target > 1000 || wCnt[target] == 0)
                    continue;

                // 짝꿍 쌍 추가
                cnt += wCnt[w] * wCnt[target];
            }
        }

        return cnt;
    }

}