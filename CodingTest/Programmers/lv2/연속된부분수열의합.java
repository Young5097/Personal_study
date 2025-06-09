class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLen = Integer.MAX_VALUE; // 초기에 비교하는 값은 무조건 minLen 보다 작게됨
        int leftIdx = 0;
        int sum = 0;

        for (int rightIdx = 0; rightIdx < sequence.length; rightIdx++) {
            sum += sequence[rightIdx];

            while (sum > k) {
                sum -= sequence[leftIdx];
                leftIdx++;
            }

            if (sum == k) {
                int currentLen = rightIdx - leftIdx + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    answer[0] = leftIdx;
                    answer[1] = rightIdx;
                }
            }

        }

        return answer;
    }
}