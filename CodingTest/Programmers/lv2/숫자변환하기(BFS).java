import java.util.LinkedList;
import java.util.Queue;

public class 숫자변환하기 {

    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, 0 });
        boolean[] visited = new boolean[y + 1];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == y) {
                return current[1];
            }

            if (current[0] + n <= y && !visited[current[0] + n]) {
                visited[current[0] + n] = true;
                queue.add(new int[] { current[0] + n, current[1] + 1 });
            }
            if (current[0] * 2 <= y && !visited[current[0] * 2]) {
                visited[current[0] * 2] = true;
                queue.add(new int[] { current[0] * 2, current[1] + 1 });
            }
            if (current[0] * 3 <= y && !visited[current[0] * 3]) {
                visited[current[0] * 3] = true;
                queue.add(new int[] { current[0] * 3, current[1] + 1 });
            }
        }
        return -1;
    }
}
