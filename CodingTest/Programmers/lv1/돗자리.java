class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                for (int mat : mats) {
                    if (canMat(park, i, j, mat)) {
                        answer = Math.max(answer, mat);
                    }
                }
            }
        }
        return answer;
    }

    private boolean canMat(String[][] park, int x, int y, int size) {

        if (x + size > park.length || y + size > park[0].length) {
            return false;
        }

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }

        return true;
    }
}