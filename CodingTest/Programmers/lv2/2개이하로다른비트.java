import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = findNextNum(numbers[i]);
        }

        return answer;
    }

    private long findNextNum(long num) {
        // 짝수는 맨 끝 비트가 0이므로 +1만 해주면 만족됨
        if (num % 2 == 0) {
            return num + 1;
        }

        // 홀수
        long nextLastBit = num;
        int count = 0;

        while ((nextLastBit & 1) == 1) { // 맨 마지막 비트 계산 (2진수)
            count++;
            nextLastBit >>= 1; // 모든 비트를 오른쪽으로 한칸씩.
        }
        /*
         * 7일때 111 / count = 3이므로 2^2 = 4
         * 7(111) + 4(100) = 11(1011)
         * 
         * 9일때 1001 / count = 1이므로 2^0 = 1
         * 9(1001) + 1(0001) = 10(1010)
         * 
         * 11일때 1011 / count = 2이므로 2^1 = 2
         * 11(1011) + 2(0010) = 13(1101)
         * 
         * 13일때 1101 / count = 2이므로 2^1 = 2
         * 13(1101) + 2(0010) = 15(1111)
         * 
         * 15일때 1111 / count = 4이므로 2^3 = 8
         * 15(1111) + 8(1000) = 23(10111)
         * 
         * 17일때 10001 / count = 1이므로 2^0 = 1
         * 17(10001) + 1(00001) = 18(10010)
         * 
         * 19일때 10011 / count = 2이므로 2^1 = 2
         * 19(10011) + 2(00100) = 21(10101)
         */

        return num + (long) Math.pow(2, count - 1);
        // -1을 해줄때마다 한자리의 비트가 추가로 달라짐
        // 대충 -1이면 비트 기준으로 가장 앞자리(0)을 포함해 그 다음 자릿수 하나를 바꾸므로 2개가 달라짐 ( ex) 7(0111) +
        // 4(0100) = 11(1011) )
        // -2이면 비트 기준으로 가장 앞자리(0)을 포함해 그 다음 자릿수 2개를 바꾸므로 3개가 잘리짐 ( ex) 7(0111) + 2(0010)
        // = 9(1001) )
        // -3이면 비트 기준으로 가장 앞자리(0)을 포함해 그 다음 자릿수 3개를 바꾸므로 4개가 잘리짐 ( ex) 7(0111) + 1(0001)
        // = 8(1000) )

    }
}
