package 자료구조;

public class gcd_lcm {
    public int gcd(int a, int b) {
        if(a==0) return b;
        return gcd(b, a%b);
    }

    public int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
