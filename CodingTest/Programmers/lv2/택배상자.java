import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> subBelt = new Stack<>();
        int answer = 0;
        int box = 1; // 컨테이너 벨트에서 꺼낼 상자 번호

        for (int i = 0; i < order.length;) {
            if (box == order[i]) {
                // 바로 트럭에 싣기
                answer++;
                box++;
                i++;
            } else if (!subBelt.isEmpty() && subBelt.peek() == order[i]) {
                // 보조 벨트에서 꺼내기
                subBelt.pop();
                answer++;
                i++;
            } else if (box <= order.length) {
                // 보조 벨트에 넣기
                subBelt.push(box);
                box++;
            } else {
                // 더 이상 실을 수 없음
                break;
            }
        }
        return answer;
    }
}