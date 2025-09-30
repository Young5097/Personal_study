package backjoon.silver.lv4;

import java.io.*;
import java.util.*;

public class 카드찾기2_10816_이분탐색 {
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        Arrays.sort(cards);
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int count = upper_idx(target) - lower_idx(target);
            sb.append(count).append(" ");
        }
    
        System.out.println(sb.toString());
    }

    public static int lower_idx(int target) {
        int st = 0;
        int en = cards.length;

        while(st < en) {
            int mid = (st+en)/2;
            if (cards[mid] >= target) {
                en = mid;
            } else {
                st = mid+1;
            }
        }
        return st;
    }

    public static int upper_idx(int target) {
        int st = 0;
        int en = cards.length;

        while (st < en) {
            int mid = (st+en)/2;
            if (cards[mid] > target) {
                en = mid;
            } else {
                st = mid+1;
            }
        }
        return en;
    }
}