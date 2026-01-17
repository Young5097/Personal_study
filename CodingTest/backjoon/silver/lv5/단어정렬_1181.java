package backjoon.silver.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어정렬_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = new String[n];
        for (int i=0; i<inputs.length; i++) {
            inputs[i] = br.readLine();
        }
        Arrays.sort(inputs, (a,b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        String current = "";
        for (int i=0; i<inputs.length; i++) {
            if (current.equals(inputs[i])) {
                continue;
            } else {
                current = inputs[i];
            }
            System.out.println(current);
        }
    }
}
