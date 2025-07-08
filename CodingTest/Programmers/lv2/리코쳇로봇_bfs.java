
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/169199

class 리코쳇로봇_bfs {

    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (board[i].charAt(j) == 'G') {
                    end[0] = i;
                    end[1] = j;

                }
            }
        }

        System.out.println("시작점: (" + start[0] + ", " + start[1] + ")");
        System.out.println("목표점: (" + end[0] + ", " + end[1] + ")");

        return bfs(start, end, board);
    }

    private int bfs(int[] start, int[] end, String[] board) {
        int n = board.length;
        int m = board[0].length();

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start[0], start[1], 0 });
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int move = current[2];

            System.out.println("현재 위치: (" + x + ", " + y + "), 이동횟수: " + move);

            if (x == end[0] && y == end[1]) {
                System.out.println("최종 이동 횟수: " + move);
                return move;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x;
                int newY = y;

                System.out.println("방향 " + i + " 탐색 시작");

                while (true) {
                    newX += dx[i];
                    newY += dy[i];

                    System.out.println("현재 위치: (" + newX + ", " + newY + ")");

                    if (newX < 0 || newY < 0 || newX >= n || newY >= m
                            || board[newX].charAt(newY) == 'D') {
                        System.out.println("  장애물 또는 범위 벗어남, 현재 위치: (" + newX + ", " + newY + ")");
                        newX -= dx[i];
                        newY -= dy[i];
                        break;
                    }
                }

                System.out.println("최종 이동 위치: (" + newX + ", " + newY + ")");

                if (!visited[newX][newY]) {
                    System.out.println("  새로운 위치 방문!");
                    visited[newX][newY] = true;
                    queue.offer(new int[] { newX, newY, move + 1 });
                } else {
                    System.out.println("  이미 방문한 위치");
                }
            }
        }
        return -1;
    }
}