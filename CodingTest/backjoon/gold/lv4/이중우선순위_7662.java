package backjoon.gold.lv4;

import java.io.*;
import java.util.*;

public class 이중우선순위_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // 연산 개수
            
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char operation = st.nextToken().charAt(0); // 'I' 또는 'D'
                int number = Integer.parseInt(st.nextToken()); // 숫자
                
                if (operation == 'I') {
                    // 삽입 연산
                    treeMap.put(number, treeMap.getOrDefault(number, 0) + 1);
                } else { // operation == 'D'
                    if (number == 1) {
                        // 최댓값 삭제
                        if (!treeMap.isEmpty()) {
                            int max = treeMap.lastKey();
                            if (treeMap.get(max) > 1) {
                                treeMap.put(max, treeMap.get(max) - 1);
                            } else {
                                treeMap.remove(max);
                            }
                        }
                    } else { // number == -1
                        // 최솟값 삭제
                        if (!treeMap.isEmpty()) {
                            int min = treeMap.firstKey();
                            if (treeMap.get(min) > 1) {
                                treeMap.put(min, treeMap.get(min) - 1);
                            } else {
                                treeMap.remove(min);
                            }
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
