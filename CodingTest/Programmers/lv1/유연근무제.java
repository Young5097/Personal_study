// https://school.programmers.co.kr/learn/courses/30/lessons/388351

class 유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int starttime = schedules[i];
            int[] timelog = timelogs[i];

            int count = 0;
            for (int j = 0; j < 7; j++) {
                int currentDay = startday + j;
                if (currentDay > 7)
                    currentDay -= 7;

                if (currentDay >= 6)
                    continue;

                int actualTime = timelog[j];
                int deadLine = starttime + 10;

                if (deadLine % 100 > 59) {
                    deadLine = (deadLine / 100 + 1) * 100 + (deadLine % 100 - 60);
                }

                if (actualTime <= deadLine)
                    count++;
            }
            if (count == 5)
                answer++;
        }

        return answer;
    }
}