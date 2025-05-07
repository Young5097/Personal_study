/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=java

    문제 설명
    카펫의 최소 가로, 세로 크기를 구하는 문제

    카펫의 넓이는 w * h -> 총 넓이는 brown + yellow
    카펫의 넓이는 최소 3 * 3 -> 최소 넓이는 9
    
    1. 3부터 시작해서 넓이와 나누어 떨어지는 수 탐색
    2. 나누어 떨어지는 수가 있으면 나눠서 가로, 세로를 구함
    3. 내부의 노란색 카펫은 테두리가 가로이므로 h-2, w-2 해서 넓이 비교
    4. 넓이가 같으면 반환
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int total = brown + yellow;

        for (int h = 3; h <= Math.sqrt(total); h++) {
            if (total % h == 0) {
                int w = total / h;
                if ((w - 2) * (h - 2) == yellow) {
                    return new int[] { w, h };
                }
            }
        }

        return answer;
    }
}