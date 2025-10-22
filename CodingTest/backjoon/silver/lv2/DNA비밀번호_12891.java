package backjoon.silver.lv2;

import java.io.*;
import java.util.StringTokenizer;

public class DNA비밀번호_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st1.nextToken());
        int P = Integer.parseInt(st1.nextToken());
        
        char[] word = br.readLine().toCharArray();
        
        int[] needChar = new int[4];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            needChar[i] = Integer.parseInt(st2.nextToken());
        }

        int[] curChar = new int[4];
        for (int i=0; i<P; i++) { // 초기 윈도우 :  ex) 0~7
            addChar(curChar, word[i]);
        }

        int count = 0;
        if (isCorrect(needChar, curChar)) count++;
 
        for (int i=P; i<S; i++) { // P=8, S=10일 때 첫 슬라이싱으로 word[0] 삭제, word[8] 추가 
            rmChar(curChar, word[i-P]);
            addChar(curChar, word[i]);

            if (isCorrect(needChar, curChar)) count++;
        }

        System.out.println(count);
    }

    static void addChar(int[] arr, char c) {
        if (c == 'A') arr[0]++;
        else if (c == 'C') arr[1]++;
        else if (c == 'G') arr[2]++;
        else if (c == 'T') arr[3]++;
    }

    static void rmChar(int[] arr, char c) {
        if (c == 'A') arr[0]--;
        else if (c == 'C') arr[1]--;
        else if (c == 'G') arr[2]--;
        else if (c == 'T') arr[3]--;
    }

    static boolean isCorrect(int[] need, int[] cur) {
        for (int i=0; i<4; i++) {
            if (need[i] > cur[i]) return false;
        }
        return true;
    }
}
