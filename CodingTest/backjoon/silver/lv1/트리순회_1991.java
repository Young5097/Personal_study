package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회_1991 {
    static int[] left = new int[26];
    static int[] right = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            int p_idx = parent - 'A';
            if (leftChild != '.') {
                left[p_idx] = leftChild - 'A';
            } else {
                left[p_idx] = -1;
            }
            if (rightChild != '.') {
                 right[p_idx] = rightChild - 'A';
            } else {
                right[p_idx] = -1;
            }
        }

        StringBuilder pre = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder post = new StringBuilder();
       
        preOrder(0, pre);
        midOrder(0, mid);
        postOrder(0, post);

        System.out.println(pre.toString());
        System.out.println(mid.toString());
        System.out.println(post.toString());
    }

    public static void preOrder(int cur_node, StringBuilder result) {
        if (cur_node == -1) return;

        result.append((char) (cur_node + 'A'));
        preOrder(left[cur_node], result);
        preOrder(right[cur_node], result);
    }

    public static void midOrder(int cur_node, StringBuilder result) {
        if (cur_node == -1) return;

        midOrder(left[cur_node], result);
        result.append((char) (cur_node + 'A'));
        midOrder(right[cur_node], result);
    }

    public static void postOrder(int cur_node, StringBuilder result) {
        if (cur_node == -1) return;

        postOrder(left[cur_node], result);
        postOrder(right[cur_node], result);
        result.append((char) (cur_node + 'A'));
    }
}