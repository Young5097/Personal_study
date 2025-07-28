import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/133502?language=java
// 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장!!

class 햄버거만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> ings = new Stack<>();
        for (int i : ingredient) {
            ings.push(i);
            
            while (ings.size() >= 4) {
                int size = ings.size(); 
                if ( (ings.get(size - 4) == 1) && (ings.get(size - 3) == 2) && (ings.get(size - 2) == 3) && (ings.get(size-1) == 1) ) {
                    for (int j=0; j<4; j++) ings.pop();
                    answer++;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}