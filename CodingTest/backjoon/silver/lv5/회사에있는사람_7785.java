package backjoon.silver.lv5;

import java.io.*;
import java.util.*;

public class 회사에있는사람_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            
            if (status.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        
        List<String> company = new ArrayList<>(set);
        Collections.sort(company, Comparator.reverseOrder());

        for (String name : company) {
            System.out.println(name);
        }
    }
}
