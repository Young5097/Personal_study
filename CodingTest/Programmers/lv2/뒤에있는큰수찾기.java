// https://school.programmers.co.kr/learn/courses/30/lessons/154539

import java.util.*;

// Stack을 통해 n번째값의 인덱스를 저장해두고 n+1번째부터의 값들과 비교
// 만약 n+1번째 값이 n번째 값보다 크다면 n번째 값의 인덱스를 스택에서 제거하고 현재 값을 저장
// 만약 n+1번째 값이 n번째 값보다 작다면 스택에 현재 값의 인덱스를 저장

public class 뒤에있는큰수찾기 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack = new Stack<>();

            // 초기값을 -1로 설정
            Arrays.fill(answer, -1);

            for (int i = 0; i < numbers.length; i++) {
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }

            return answer;
        }
    }
}
