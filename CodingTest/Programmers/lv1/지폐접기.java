package lv1;

// https://school.programmers.co.kr/learn/courses/30/lessons/340199

class 지폐접기 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int width = bill[0], height = bill[1];

        while (!fit(width, height, wallet[0], wallet[1])) {
            if (width > height)
                width /= 2;
            else
                height /= 2;
            answer++;
        }

        return answer;
    }

    private boolean fit(int width, int height, int wallet_w, int wallet_h) {
        return (width <= wallet_w && height <= wallet_h) || (width <= wallet_h && height <= wallet_w);
    }
}