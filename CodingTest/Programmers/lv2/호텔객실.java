import java.util.*;

class 호텔객실 {
    public int solution(String[][] book_time) {
        // 1. 시간 순 정렬(오름차순) : 분(minutes)로 변환 후 계산하면 된다.
        Arrays.sort(book_time, (a, b) -> {
            return changeToMinutes(a[0]) - changeToMinutes(b[0]);
        });

        // 2. 우선순위 큐를 통해 사용가능한 객실 시간을 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 3. 각 예약시간 처리
        for (String[] book : book_time) {
            int startTime = changeToMinutes(book[0]);
            int endTime = changeToMinutes(book[1]) + 10; // 청소시간

            // 예약이 있는데, 그 종료 시간보다 현재 객실의 시작시간이 늦은 경우 (다음에 바로 사용가능한 경우)
            if (!pq.isEmpty() && pq.peek() <= startTime) {
                // 기존 객실 사용 (추가 사용할 객실이 필요없으므로 빼고 다음 대실의 종료시간으로 update)
                // 다음 예약자를 offer 하므로 사용할 객실의 수는 변화 X
                pq.poll();
            }

            pq.offer(endTime);
        }

        return pq.size();
    }

    private int changeToMinutes(String time) {
        String[] split_s = time.split(":");
        int hours = Integer.parseInt(split_s[0]);
        int minutes = Integer.parseInt(split_s[1]);
        return (hours * 60) + minutes;
    }
}