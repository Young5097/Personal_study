
/*
n : 실행중인 서버 갯수
m <= k : 서버증설필요
if (n*m < players[i] < n*m + 1) : 최소 n개 이상
증설된 서버는 k시간동안만 운영
*/
import java.util.*;

class 서버증설횟수 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] expansions = new int[players.length];

        for (int t = 0; t < players.length; t++) {
            int needServers = (int) Math.ceil(players[t] / m); // (n + m -1 / m)도 가능

            int runnings = 0;
            if (t >= k) { // k가 3이고 현재시간이 5시이면 ? 3~6/4~7까지 유지되는 서버를 이용가능
                for (int prev = t - k + 1; prev < t; prev++) {
                    runnings += expansions[prev];
                }
            } else {
                for (int prev = 0; prev < t; prev++) {
                    runnings += expansions[prev];
                }
            }

            int addtional = Math.max(0, needServers - runnings);
            expansions[t] = addtional;
            answer += addtional;

        }

        return answer;
    }
}