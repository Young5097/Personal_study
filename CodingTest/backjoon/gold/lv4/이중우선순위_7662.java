package backjoon.gold.lv4;

import java.io.*;
import java.util.*;

public class 이중우선순위_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); 
            
                TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char oper = st.nextToken().charAt(0); // 'I' 또는 'D'
                int n = Integer.parseInt(st.nextToken()); // 숫자
                
                if (oper == 'I') {
                    treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
                } else {
                    int key = 0;
                    if (!treeMap.isEmpty()) {
                        key = n==1?treeMap.lastKey():treeMap.firstKey();
                        if (treeMap.get(key) > 1) {
                            treeMap.put(key, treeMap.get(key)-1);
                        } else {
                            treeMap.remove(key);
                        }
                    }
                }
            }
            
            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}
