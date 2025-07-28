import java.util.*;

class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> termsMap = new HashMap<>();
        for (String t : terms) {
            termsMap.put(t.split(" ")[0], Integer.parseInt(t.split(" ")[1]));
        }
        
        int todayDay = dateToDay(today);
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            String date = parts[0];
            String type = parts[1];
            
            int toDay = dateToDay(date);
            int validMonth = termsMap.get(type);
            int expireDay = toDay + (validMonth * 28);
            
            if (expireDay <= todayDay) {
                result.add(i+1);
            }   
        }
        
        Collections.sort(result);
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    private int dateToDay(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        // year >= 2000, month는 1월부터 시작하므로 6월일 경우, 5개월이 흐른거임, 그래서 -1 해줘야함
        return (year - 2000) * 12 * 28 + (month - 1) * 28 + day;
    }
}