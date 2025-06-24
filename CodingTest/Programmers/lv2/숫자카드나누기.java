public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        // 철수 카드들의 최대공약수 구하기
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        // 영희 카드들의 최대공약수 구하기
        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // gcdN이 1이란 것은, 모두 나눌 수 없다는 뜻임
        // 조건 1: 철수의 GCD가 영희 카드들을 나누지 못하는지 확인
        if (gcdA > 1 && canDivideAll(gcdA, arrayA) && !canDivideAny(gcdA, arrayB)) {
            answer = Math.max(answer, gcdA);
        }

        // 조건 2: 영희의 GCD가 철수 카드들을 나누지 못하는지 확인
        if (gcdB > 1 && canDivideAll(gcdB, arrayB) && !canDivideAny(gcdB, arrayA)) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    // 최대공약수 구하기
    /*
     * 유클리드 호재법... (a, b)에 큰 수, 작은 수 순서는 상관 X
     * 
     * 핵심 : A와 B를 나눈 수는, 나머지 r도 나눌 수 있다! (A, B) = (B, r)
     * 
     * 두 수 a, b가 있을 때, a를 b로 나눈 나머지를 r이라고 하면,
     * a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
     * 이를 반복하여, b가 0이 될 때까지 반복하면, a가 최대공약수가 된다.
     * 
     * 예를 들어, 12와 18의 최대공약수를 구해보자.
     * 12와 18의 최대공약수는 12와 18의 최대공약수와 같다.
     * 1. 12와 18의 최대공약수는 6이다. (18 % 12 = 6)
     * 2. 6과 12의 최대공약수는 6이다. (12 % 6 = 0)
     * 3. 6과 0의 최대공약수는 6이다. (6 % 0 = 0)
     * 따라서, 12와 18의 최대공약수는 6이다.
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // num이 배열의 모든 원소를 나눌 수 있는지 확인
    private boolean canDivideAll(int num, int[] arr) {
        for (int val : arr) {
            if (val % num != 0) {
                return false;
            }
        }
        return true;
    }

    // num이 배열의 원소 중 하나라도 나눌 수 있는지 확인
    private boolean canDivideAny(int num, int[] arr) {
        for (int val : arr) {
            if (val % num == 0) {
                return true;
            }
        }
        return false;
    }
}
