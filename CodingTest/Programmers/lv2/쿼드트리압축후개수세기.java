// https://school.programmers.co.kr/learn/courses/30/lessons/68936
// 완전탐색 + 분할정복

class Solution {
    public int[] solution(int[][] arr) { // arr은 가로, 세로가 길이가 같음
        int[] answer = new int[2];
        zipArr(arr, 0, 0, arr.length, answer);
        return answer;
    }

    private void zipArr(int[][] arr, int x, int y, int size, int[] answer) {
        if (chkBlock(arr, x, y, size)) {
            int value = arr[x][y];
            if (value == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;
        }

        int newSize = size / 2;
        zipArr(arr, x, y, newSize, answer);
        zipArr(arr, x, y + newSize, newSize, answer);
        zipArr(arr, x + newSize, y, newSize, answer);
        zipArr(arr, x + newSize, y + newSize, newSize, answer);
    }

    private boolean chkBlock(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value)
                    return false;
            }
        }
        return true;
    }
}