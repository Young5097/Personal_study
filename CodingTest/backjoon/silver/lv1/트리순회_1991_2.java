package backjoon.silver.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회_1991_2 {
    static int[][] binary_tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        binary_tree = new int[26][2]; // 0 : left, 1 : right
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            int p_idx = parent - 'A';
            if (leftChild != '.') {
                binary_tree[p_idx][0] = leftChild - 'A';
            } else {
                binary_tree[p_idx][0] = -1;
            }
            if (rightChild != '.') {
                binary_tree[p_idx][1] = rightChild - 'A';
            } else {
                binary_tree[p_idx][1] = -1;
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    static void preOrder(int now) {
        if (now == -1) return;

        System.out.print((char) (now + 'A'));
        preOrder(binary_tree[now][0]);
        preOrder(binary_tree[now][1]);
    }
    
    static void inOrder(int now) {
        if (now == -1) return;
        
        inOrder(binary_tree[now][0]);
        System.out.print((char) (now + 'A'));
        inOrder(binary_tree[now][1]);
    }
    
    static void postOrder(int now) {
        if (now == -1) return;

        postOrder(binary_tree[now][0]);
        postOrder(binary_tree[now][1]);
        System.out.print((char) (now + 'A'));
    }
}