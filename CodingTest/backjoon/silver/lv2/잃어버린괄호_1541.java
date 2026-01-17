package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strSet = br.readLine().split("\\-");
        int[] numArr = new int[strSet.length];
        for (int i=0; i<strSet.length; i++) {
            int total = 0;
            String[] str = strSet[i].split("\\+");
            for (String s : str) {
                int n = Integer.parseInt(s);
                total += n;
            }
            numArr[i] = total;
        }

        int result = numArr[0];
        for (int i=1; i<numArr.length; i++) {
            result -= numArr[i];
        }
        
        System.out.println(result);
    }
}
