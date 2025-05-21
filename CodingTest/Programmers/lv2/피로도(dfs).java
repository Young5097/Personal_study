import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946

public class 피로도 {
    class Solution {
        boolean[] visited; // 방문 체크 배열
        int maxDungeons = 0; // 최대 던전 수

        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];
            dfs(k, dungeons, 0);
            return maxDungeons;
        }

        private void dfs(int k, int[][] dungeons, int count) {
            // 현재까지 탐험한 던전 수와 최대값 비교
            maxDungeons = Math.max(maxDungeons, count);

            // 모든 던전에 대해 시도
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && k >= dungeons[i][0]) {
                    visited[i] = true;
                    dfs(k - dungeons[i][1], dungeons, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
