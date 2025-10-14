package backjoon.silver.lv4;

import java.io.*;
import java.util.*;

public class 문자열집합_14425_트라이2 { // 노드번호를 알 수 없음

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String s) {
            TrieNode cur_node = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (cur_node.children[i] == null) {
                    cur_node.children[i] = new TrieNode();
                }
                cur_node = cur_node.children[i];
            }
            cur_node.isEnd = true;
        }

        boolean find(String s) {
            TrieNode cur_node = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (cur_node.children[i] == null) return false;
                cur_node = cur_node.children[i];
            }
            return cur_node.isEnd;
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
