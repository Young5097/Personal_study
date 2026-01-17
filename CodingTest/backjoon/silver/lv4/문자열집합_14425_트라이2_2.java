package backjoon.silver.lv4;

import java.io.*;
import java.util.*;

public class 문자열집합_14425_트라이2_2 { // 노드번호를 알 수 없음

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String s) {
            TrieNode curNode = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (curNode.children[i] == null) {
                    curNode.children[i] = new TrieNode();
                }
                curNode = curNode.children[i];
            }
            curNode.isEnd = true;
        }

        boolean find(String s) {
            TrieNode curNode = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (curNode.children[i] == null) {
                    return false;
                }
                curNode = curNode.children[i];
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


    }
}
