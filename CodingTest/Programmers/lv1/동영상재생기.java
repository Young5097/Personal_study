class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int fullTime = toMinutes(video_len);
        int currentMin = toMinutes(pos);
        int op_start_int = toMinutes(op_start);
        int op_end_int = toMinutes(op_end);

        if (currentMin >= op_start_int && currentMin <= op_end_int) {
            currentMin = op_end_int;
        }

        for (String command : commands) {

            if (command.equals("prev")) {
                currentMin -= 10;
                if (currentMin < 0)
                    currentMin = 0;
            } else if (command.equals("next")) {
                currentMin += 10;
                if (currentMin > fullTime)
                    currentMin = fullTime;
            }

            if (currentMin >= op_start_int && currentMin <= op_end_int) {
                currentMin = op_end_int;
            }

        }

        int min = currentMin / 60;
        int sec = currentMin % 60;
        return String.format("%02d:%02d", min, sec);
    }

    private int toMinutes(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}