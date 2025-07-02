import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12978

class 배달_bfs {
    public int solution(int N, int[][] road, int K) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int distance = r[2];
            // graph의 index = 마을번호 => 각 마을번호에 a : [{b, distance}, {c, distance}]를 저장
            graph.get(a).add(new int[] { b, distance });
            graph.get(b).add(new int[] { a, distance });
        }

        int[] distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0; // 시작점은 0

        // 거리 기반 우선순위 큐 (a-b -> 오름차순)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // LinkedList<int[]> pq = new LinkedList<>();
        pq.offer(new int[] { 1, 0 }); // {마을 번호, 거리}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int town = current[0];
            int distance = current[1];

            if (distances[town] < distance) {
                continue;
            }

            // 현재 마을에서 인접한 마을들까지의 거리체크
            for (int[] nearby : graph.get(town)) {
                int nearTown = nearby[0];
                int nearDistance = nearby[1];

                if (distances[nearTown] > distance + nearDistance) {
                    distances[nearTown] = distance + nearDistance;
                    pq.offer(new int[] { nearTown, distance + nearDistance });
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distances[i] <= K) {
                count++;
            }
        }

        return count;
    }
}