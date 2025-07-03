// https://school.programmers.co.kr/learn/courses/30/lessons/12899

class 나라_124 {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n != 0) {
            int num = n % 3;
            if (num == 0) {
                // 3의 배수는 끝이 항상 4이며, n/3 -1 후에 3진법으로 계산, 만약 3진법 계산 결과가 0이면 4
                // 6->14일때, 6/3 -1 = 1이고 3진법 계산하면 1, 뒤에 4를 더하면 14
                // 9->24일때, 9/3 -1 = 2이고 3진법 계산하면 2, 뒤에 4를 더하면 24
                // 12->44일때. 12/3 -1 = 3이고 3진법 계산하면 0, 0일때는 4이고 뒤에 4를 더하면 44
                answer.append(4);
                n = n / 3 - 1;
            } else {
                answer.append(num);
                n /= 3;
            }
        }

        return answer.reverse().toString();
    }
}
