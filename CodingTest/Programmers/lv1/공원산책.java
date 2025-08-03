public class 공원산책 {
    public int[] solution(String[] park, String[] routes) {
        // 시작점 찾기
        int x = 0, y = 0;
        for (int i = 0; i < park.length; i++) {
            int idx = park[i].indexOf('S');
            if (idx != -1) {
                x = i;
                y = idx;
                break;
            }
        }

        // 명령 실행
        for (String route : routes) {
            String[] cmd = route.split(" ");
            String dir = cmd[0];
            int dist = Integer.parseInt(cmd[1]);

            int nx = x, ny = y;

            // 이동할 위치 계산
            if (dir.equals("E"))
                ny += dist;
            else if (dir.equals("W"))
                ny -= dist;
            else if (dir.equals("S"))
                nx += dist;
            else
                nx -= dist; // N

            // 경로 체크
            boolean canMove = true;

            // 범위 체크
            if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length()) {
                canMove = false;
            } else {
                // 경로에 장애물 체크
                int startX = Math.min(x, nx);
                int endX = Math.max(x, nx);
                int startY = Math.min(y, ny);
                int endY = Math.max(y, ny);

                for (int i = startX; i <= endX; i++) {
                    for (int j = startY; j <= endY; j++) {
                        if (park[i].charAt(j) == 'X') {
                            canMove = false;
                            break;
                        }
                    }
                    if (!canMove)
                        break;
                }
            }

            if (canMove) {
                x = nx;
                y = ny;
            }
        }

        return new int[] { x, y };
    }
}