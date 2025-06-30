import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/159993

public class 미로탈출_BFS {

    private static int[] dx = { 0, 0, 1, -1 };
    private static int[] dy = { 1, -1, 0, 0 };

    static class Point {
        int x;
        int y;
        int time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char obj = maps[i].charAt(j);
                if (obj == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (obj == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (obj == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int startToLever = bfs(maps, start[0], start[1], lever[0], lever[1]);
        if (startToLever == -1)
            return -1;

        int leverToEnd = bfs(maps, lever[0], lever[1], end[0], end[1]);
        if (leverToEnd == -1)
            return -1;

        return startToLever + leverToEnd;
    }

    private int bfs(String[] maps, int startX, int startY, int endX, int endY) {
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();

            if (curPoint.x == endX && curPoint.y == endY) {
                return curPoint.time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curPoint.x + dx[i];
                int ny = curPoint.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, curPoint.time + 1));
                }
            }

        }

        return -1;
    }
}
