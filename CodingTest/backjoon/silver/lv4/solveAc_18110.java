package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solveAc_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i=0; i<N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        int cutAvg = (int) Math.round((double) N * 0.15);
        arr = arr.subList(cutAvg, N-cutAvg);

        int result = (int) Math.round(arr.stream().mapToInt(Integer::intValue).average().orElse(0.0));
        System.out.println(result);
    }
}
