package backjoon.bronze.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACM호텔_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nn = Integer.parseInt(br.readLine());
        for (int i=0; i<nn; i++) {
            String[] arr = br.readLine().split(" ");
            int H = Integer.parseInt(arr[0]);
            int W = Integer.parseInt(arr[1]);
            int N = Integer.parseInt(arr[2]);


            int prefix = N % H;
            if (prefix == 0) {
                prefix = H;
            }
            int postfix = (int) Math.ceil((double) N / H); 
            System.out.println(prefix*100 + postfix);
        }
    }
}
