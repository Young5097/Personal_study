package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = 0;
        int count = 0;

        for (int i=0; i<m-2; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i+1) == 'O') {
                i++;
                if (i<m && s.charAt(i+1) == 'I') {
                    count++;

                    if (count == n) {
                        answer++;
                        count--;
                    }
                } else {
                    count = 0;
                }   
            } else {
                count = 0;
            }
        }

        System.out.println(answer);
    }
}
