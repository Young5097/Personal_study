package backjoon.bronze.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        
        long mod = 1234567891;
        long result = 0;
        long pow = 1;
        for (int i=0; i<N; i++) {
            int n = str[i] - 'a' + 1;
            result = (result + (n * pow)%mod)*mod;
            pow = (pow*31)%mod;
        }

        System.out.println(result);
    }
}
