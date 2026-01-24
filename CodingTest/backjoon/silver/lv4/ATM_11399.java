package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(line);
        
        int[] time = new int[n];
        time[0] = line[0];

        int result = time[0];
        for (int i=1; i<n; i++) {
            time[i] = time[i-1] + line[i];
            result += time[i];
        }
        
        System.out.println(result);
    }
}
