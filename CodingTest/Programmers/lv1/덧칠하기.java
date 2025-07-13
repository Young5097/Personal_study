package lv1;

class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] visited = new boolean[n + 1]; // boolean 배열은 기본이 모두 false로 채워짐!

        for (int s : section) {
            visited[s] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == true) {
                answer++;

                for (int j = i; j < i + m && j <= n; j++) {
                    visited[j] = false;
                }
            }
        }
        return answer;
    }
}