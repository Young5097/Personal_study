package lv1;

import java.util.HashMap;
import java.util.Map;

public class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        // 1. 주고받은 선물 기록
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (String f : friends) {
            map.put(f, new HashMap<>());
        }

        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String sender = gift[0];
            String receiver = gift[1];

            Map<String, Integer> giftMap = map.get(sender);
            giftMap.put(receiver, giftMap.getOrDefault(receiver, 0) + 1);
        }

        // 2. 선물지수 기록
        Map<String, Integer> giftScore = new HashMap<>();
        for (String friend : friends) {
            int send = 0;
            int receive = 0;

            Map<String, Integer> sendMap = map.get(friend);
            for (int count : sendMap.values()) {
                send += count;
            }

            for (String other : friends) {
                if (!other.equals(friend)) {
                    receive += map.get(other).getOrDefault(friend, 0);
                }
            }

            giftScore.put(friend, send - receive);
        }

        // 3. 다음달 선물예측
        Map<String, Integer> nextMonthGift = new HashMap<>();
        for (String friend : friends) {
            nextMonthGift.put(friend, 0);
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String friend1 = friends[i];
                String friend2 = friends[j];

                int f1tof2 = map.get(friend1).getOrDefault(friend2, 0);
                int f2tof1 = map.get(friend2).getOrDefault(friend1, 0);

                if (f1tof2 > f2tof1) {
                    nextMonthGift.put(friend1, nextMonthGift.get(friend1) + 1);
                } else if (f2tof1 > f1tof2) {
                    nextMonthGift.put(friend2, nextMonthGift.get(friend2) + 1);
                } else {
                    int scoreF1 = giftScore.get(friend1);
                    int scoreF2 = giftScore.get(friend2);

                    if (scoreF1 > scoreF2) {
                        nextMonthGift.put(friend1, nextMonthGift.get(friend1) + 1);
                    } else if (scoreF2 > scoreF1) {
                        nextMonthGift.put(friend2, nextMonthGift.get(friend2) + 1);
                    }
                }
            }
        }

        // 4. max 선물 찾기
        int answer = 0;
        for (int giftCount : nextMonthGift.values()) {
            answer = Math.max(answer, giftCount);
        }

        return answer;
    }
}
