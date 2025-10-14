package 자료구조;

import java.util.Arrays;

public class 트라이 {
    final int ROOT = 1;
    final int MX = 10000*500 + 5; // 길이가 최대 500인 문자열 10000개
    int unused = 2;

    boolean[] chk = new boolean[MX]; // 단어의 마지막(트리의 끝)을 기록
    int[][] nxt = new int[MX][26]; 

    public 트라이() {
        for (int i=0; i<MX; i++) {
            Arrays.fill(nxt[i], -1);
        }
    }

    public int c2i(char c) {
        return c - 'A';
    }    

    public void insert(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            if (nxt[cur][c2i(c)] == -1) {
                nxt[cur][c2i(c)] = unused++; // 다음 노드번호 할당. 다음 char의 할당을 위해 +1
            }
            cur = nxt[cur][c2i(c)];
        }
        chk[cur] = true;
    }

    public boolean find(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            if (nxt[cur][c2i(c)] == -1) return false;
            cur = nxt[cur][c2i(c)]; // 백트랙킹이랑 유사. nxt[cur][c1] = nxt_node이므로 다음으로는 nxt[nxt_node][c2]
        }
        return chk[cur];
    }

    public void erase(String s) {
        int cur = ROOT;
        for (char c : s.toCharArray()) {
            if (nxt[cur][c2i(c)] == -1) return;
            cur = nxt[cur][c2i(c)];
        }
        chk[cur] = false;
    }
}
