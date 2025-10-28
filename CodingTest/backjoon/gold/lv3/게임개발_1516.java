package backjoon.gold.lv3;
/*
* 건물들은 동시에 지어질 수 있지만, 선행되어야 하는 건물들이 있음
* 예시: 4번 건물을 지으려면 2, 3번 건물이 필요하고, 2, 3번 건물은 1번 건물이 필요
* 
* 1번(10초) 완료 후
* → 2번(20초), 3번(5초) 동시 시작
* → 둘 중 늦게 끝나는 2번 기다림 (max(20, 5) = 20)
* → 1번 완료 후 20초 뒤 4번 시작 가능
* → 4번 완료: (10 + 20) + 4의 시간
* 
* 위상 정렬을 통해 선행 건물을 먼저 처리하고,
* DP로 각 건물의 완료 시간 = max(모든 선행 건물 완료 시간) + 자신의 건설 시간
*/

/*
* 결론: 위상정렬은 "여러 선행 조건을 모두 만족해야 하는" 순서 문제에 사용
* - 진입 차수(indegree): 해당 노드로 들어오는 간선의 개수
* - 진입 차수가 0이 되어야(= 모든 선행 조건 만족) 처리 가능
*/

import java.util.*;

public class 게임개발_1516 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 건물의 종류 수
        
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDeg = new int[N+1];
        int[] self_build = new int[N+1];
        int[] total_build = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int time = sc.nextInt();
            self_build[i] = time;
            
            // 먼저 지어져야 하는 건물들
            while (true) {
                int pre = sc.nextInt();
                if (pre == -1) break;
                graph[pre].add(i);
                inDeg[i]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
                total_build[i] = self_build[i];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : graph[cur]) {
                inDeg[nxt]--;
                total_build[nxt] = Math.max(total_build[nxt], total_build[cur] + self_build[nxt]);
                if (inDeg[nxt] == 0) {
                    queue.add(nxt);
                }
            }
        }

        for (int i=1; i<=N; i++) {
            System.out.println(total_build[i]);
        }
    }
}
