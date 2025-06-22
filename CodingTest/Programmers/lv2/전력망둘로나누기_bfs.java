import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/86971
// BFS

class 전력망둘로나누기_bfs {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int count1 = countConnectNodes(n, wires, i);
            int count2 = n - count1;

            int diff = Math.abs(count1 - count2);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    // cutIndex는 짜를 연결( ex) [1,2] )의 index / 동시에 연결이 짤린 후, count를 시작할 송전탑
    // 송전탑의 번호는 1~N까지 / wires를 보면 Index가 아닌 실제 송전탑의 번호가 들어있으므로 visited의 크기는 N+1
    public int countConnectNodes(int n, int[][] wires, int cutIndex) {
        int count = 1; // 시작하는 탑도 포함
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        int startNode = wires[cutIndex][0];
        queue.add(startNode); // 전선을 끊고 연결된 송전탑의 count를 시작할 송전탑
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int i = 0; i < wires.length; i++) {
                if (i == cutIndex)
                    continue; // 제거한 전선은 제외(현재 cutIndex)

                int v1 = wires[i][0];
                int v2 = wires[i][1];

                if (v1 == currentNode && !visited[v2]) {
                    queue.offer(v2); // 연결이 확인된 송전탑(노드)를 다음 반복문에서 확인
                    visited[v2] = true;
                    count++;
                } else if (v2 == currentNode && !visited[v1]) {
                    queue.offer(v1);
                    visited[v1] = true;
                    count++;
                }
            }
        }

        return count;
    }
}