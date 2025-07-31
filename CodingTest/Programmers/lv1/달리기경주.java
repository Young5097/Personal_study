import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871

class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            list.add(players[i]);
        }

        for (String callPlayer : callings) {
            /*
             * Map은 해시 테이블로 구현되어 있어서 키를 찾는 것이 O(1)의 시간 복잡도를 가짐
             * hash % size = index라서 매우 빠름
             * 
             * 반면 List는 배열은 순차적으로 순회하여 O(n)의 시간 복잡도를 가짐
             * list.indexOf()를 통해 찾는 것은 상위 for문과 합치면 시간 복잡도가 O(n^2)이 되어서 시간 초과가 발생함
             */
            int currentPos = map.get(callPlayer);

            if (currentPos == 0) {
                continue;
            }

            String frontPlayer = list.get(currentPos - 1);
            list.set(currentPos - 1, callPlayer);
            list.set(currentPos, frontPlayer);

            map.put(callPlayer, currentPos - 1);
            map.put(frontPlayer, currentPos);
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}