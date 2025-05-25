import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42626

// PriorityQueue : 우선 순위 큐
// 우선 순위 큐는 데이터를 정렬된 순서로 저장하는 자료구조
// 데이터를 정렬된 순서로 저장하기 때문에 최소값 또는 최대값을 쉽게 찾을 수 있음

public class 더맵게 {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        int count = 0;

        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }

            // 우선순위큐는 가장 작은 수부터 뽑힘
            int first = pq.poll();
            int second = pq.poll();

            int newScoville = first + (second * 2);
            pq.offer(newScoville);

            count++;
        }

        return count;
    }
}
