package backjoon.silver.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시리얼번호_1431_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] serials = new String[N];
        
        for (int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }
        
    //     Arrays.sort(serials, new Comparator<String>() {
    //         @Override
    //         public int compare(String a, String b) {
    //             if (a.length() != b.length()) {
    //                 return a.length() - b.length();
    //             }

    //             int sumA = getSum(a);
    //             int sumB = getSum(b);

    //             if (sumA != sumB) {
    //                 return sumA - sumB;
    //             }

    //             return a.compareTo(b);
    //         }
    //     });

        for (int i=0; i<N-1; i++) {
            for (int j=0; j<N-1-i; j++) {
                if (compare(serials[j], serials[j+1])) {
                    String temp = serials[j];
                    serials[j] = serials[j+1];
                    serials[j+1] = temp;
                }
            }
        }

        for (String serial : serials) {
            System.out.println(serial);
        }
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() > b.length();
        }
        int sumA = getSum(a);
        int sumB = getSum(b);
        if (sumA != sumB) {
            return sumA > sumB;
        }
        return a.compareTo(b) > 0; // a>b이면 true
    }

    public static int getSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }
}
