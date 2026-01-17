package backjoon.bronze.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISBN_14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();
        
        int total = 0;
        int brokenWeight= 1;
        for(int i=0; i<isbn.length(); i++) {
            char c = isbn.charAt(i);
            if (c == '*') {
                brokenWeight = (i % 2 == 0) ? 1 : 3;
            } else {
                int n = c - '0';
                int weight = (i % 2 == 0) ? 1 : 3;
                total += n * weight;
            }
        } 

        for (int i=0; i<=9; i++) {
            if ((total + (i*brokenWeight)) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
