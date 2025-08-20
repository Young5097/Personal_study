package lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/389478

public class 택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        // 1. num번 상자의 index 위치 찾기
        int row = (num - 1) / w; // 몇 번째 행인지
        int col = (num - 1) % w; // 몇 번째 열인지
        // 짝수 행(index = 1, 3, 5, ...)은 오른쪽에서 왼쪽으로 쌓임
        if (row % 2 == 1) {
            col = w - col - 1;
        }

        // 2. 총 row 갯수 및 맨위에 남은 상자 갯수 카운트
        int top_row = (n - 1) / w;
        int remain_box = n % w;
        int result = top_row - row;

        // 딱 맞아떨어지면 계산할 필요X
        if (remain_box == 0) {
            return result + 1; // index 기준이므로 + 1
        }

        // 3. 열 가장 상단의 박스 유무 여부 체크
        int[] top_arr = new int[w];
        if (top_row % 2 == 1) { // 짝수행
            for (int i = 0; i < remain_box; i++) {
                top_arr[w - i - 1] = 1;
            }
        } else { // 홀수행
            for (int i = 0; i < remain_box; i++) {
                top_arr[i] = 1;
            }
        }

        if (top_arr[col] == 1) {
            result += 1;
        }

        return result;
    }
}