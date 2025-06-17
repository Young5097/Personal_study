// https://school.programmers.co.kr/learn/courses/30/lessons/148653?language=java
class 마법의엘리베이트 {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int remain = storey % 10;
            System.out.println("remain: " + remain);
            storey /= 10;
            System.out.println("storey: " + storey);

            if (remain > 5) {
                answer += (10 - remain);
                storey++;
            } else if (remain == 5 && storey % 10 >= 5) {

                answer += remain;
                storey++;
            } else {
                answer += remain;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        마법의엘리베이트 solution = new 마법의엘리베이트();
        System.out.println(solution.solution(1555));
    }
}