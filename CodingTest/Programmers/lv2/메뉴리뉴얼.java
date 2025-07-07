import java.util.*;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/72411

주문 조합 : orders
각 코스요리의 요리 갯수 : course

조건
1. 최소 2가지 이상의 메뉴가 코스에 포함
2. 최소 2명의 손님이 음식 조합을 주문했어야함
*/
class 메뉴리뉴얼 {
    public String[] solution(String[] orders, int[] courses) {

        List<String> result = new ArrayList<>();

        // 각 코스요리의 요리 갯수별로 처리
        for (int course : courses) {
            Map<String, Integer> courseAndCount = new HashMap<>();

            // 각 주문에서 코스요리의 요리 갯수별로 조합 생성
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);

                generateCourse(chars, course, 0, 0, new char[course], courseAndCount);
            }

            // 최대 주문 횟수 찾기
            int maxCount = 0;
            for (int count : courseAndCount.values()) {
                if (count >= 2) {
                    maxCount = Math.max(maxCount, count);
                }
            }

            // 최대 주문 횟수와 최소 2명 이상의 주문 횟수를 만족하는 조합 추가
            for (String key : courseAndCount.keySet()) {
                if (courseAndCount.get(key) >= maxCount && courseAndCount.get(key) >= 2) {
                    result.add(key);
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[result.size()]);
    }

    // 조합 생성 함수
    private void generateCourse(char[] chars, int size, int startIdx, int currentIdx, char[] currentCourse,
            Map<String, Integer> courseAndCount) {
        // 코스의 요리 갯수만큼 조합이 완성되면 조합 추가
        if (size == currentIdx) {
            String course = new String(currentCourse);
            courseAndCount.put(course, courseAndCount.getOrDefault(course, 0) + 1);
            return;
        }

        // 조합 생성 요리가 5개이고 원하는 코스요리 갯수가 3이면 5C3 조합 생성
        for (int i = startIdx; i < chars.length; i++) {
            currentCourse[currentIdx] = chars[i];
            generateCourse(chars, size, i + 1, currentIdx + 1, currentCourse, courseAndCount);
        }
    }
}