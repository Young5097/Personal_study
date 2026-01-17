package backjoon.silver.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 요제푸스_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        
        List<Integer> curList = new ArrayList<>();
        for (int i=0;i<N;i++) {
            curList.add(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = 0;
        while (!curList.isEmpty()) {
            idx += K-1;
            while (idx >= N) {
                idx -= N;
            }

            if (curList.size() == 1) {
                sb.append(curList.get(idx));
                break;
            }

            sb.append(curList.get(idx)).append(", ");
            curList.remove(idx);
            N -= 1;
        }
        
        sb.append(">");
        System.out.println(sb.toString());
    }
}
