package lv1;

public class 소수찾기 {
    int count = 0;

    public int solution(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    public boolean isPrime(int n) {

        if (n < 2)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;

        // 약수는 쌍을 가지므로 sqrt(n)까지만 확인하면 됨
        // 소수는 1과 본인을 제외한 약수가 X
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
