import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>(); // 중복X
        int n = elements.length;

        // 시작 위치
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int len = 1; len <= n; len++) {
                /*
                 * 원형수열이므로 끝을 넘어가면 다시 처음으로 가야함
                 * ex) start = 2(원형수열에선 3번째 수), len 5 -> 1 (원형수열 2번째 수를 sum에 더함)
                 */
                int index = (start + len - 1) % n;
                sum += elements[index];
                sums.add(sum);
            }
        }

        return sums.size();

    }
}
