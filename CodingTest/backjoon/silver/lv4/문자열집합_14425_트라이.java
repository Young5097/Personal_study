package backjoon.silver.lv4;

import java.io.*;
import java.util.*;

public class 문자열집합_14425_트라이 {

    static class Trie {
        final int ROOT = 1;
        final int MX = 500 * 10000 + 5;
        int unused = 2;

        boolean[] chk = new boolean[MX];
        int[][] ntx = new int[MX][26];

        public Trie() {
            for (int i = 0; i < MX; i++) {
                Arrays.fill(ntx[i], -1); 
            }
        }

        public int c2i(char c) {
            return c - 'a';
        }

        public void insert(String s) {
            int cur = ROOT;
            for (char c : s.toCharArray()) {
                if (ntx[cur][c2i(c)] == -1) {
                    ntx[cur][c2i(c)] = unused++;
                }
                cur = ntx[cur][c2i(c)];
            }
            chk[cur] = true;
        }

        public boolean find(String s) {
            int cur = ROOT;
            for (char c : s.toCharArray()) {
                if (ntx[cur][c2i(c)] == -1) return false;
                cur = ntx[cur][c2i(c)];
            }
            return chk[cur];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        for (int i=0; i<N; i++) {
            trie.insert(br.readLine());
        }

        int count = 0;
        for (int i=0; i<M; i++) {
            if (trie.find(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
