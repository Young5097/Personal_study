//https://school.programmers.co.kr/learn/courses/30/lessons/161990

class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {

        int startX = Integer.MAX_VALUE, endX = Integer.MIN_VALUE; // startX는 최솟값, endX는 최댓값
        int startY = Integer.MAX_VALUE, endY = Integer.MIN_VALUE; // startY는 최솟값, endY는 최댓값

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].toCharArray()[j] == '#') {
                    // 격자 안에 파일이 있음 : x는 index에 따라서 그대로 n, y는 n+1
                    startX = Math.min(startX, i);
                    startY = Math.min(startY, j);
                    endX = Math.max(endX, i + 1);
                    endY = Math.max(endY, j + 1);
                }
            }
        }
        return new int[] { startX, startY, endX, endY };
    }
}
