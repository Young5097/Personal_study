import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] visited = new int[n + 1];
        Arrays.fill(visited, 1);

        for (int l : lost)
            visited[l]--;
        for (int res : reserve)
            visited[res]++;

        for (int i = 1; i <= n; i++) {
            if (i > 1 && visited[i] == 2 && visited[i - 1] == 0) {
                visited[i]--;
                visited[i - 1]++;
            } else if (i < n && visited[i] == 2 && visited[i + 1] == 0) {
                visited[i]--;
                visited[i + 1]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}