package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] answer = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 스택에 인덱스를 저장
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i=1; i<N; i++) {
            // 스택에 들어오는 인덱스(new_idx)의 값이 가장 위의 인덱스(pop_idx)의 값보다 작으면, 
            // answer[pop_idx]를 A[new_idx]로 업데이트하고 pop()과 push(new_idx)를 수행
            // 아니라면 그냥 push(new_idx)
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        // 오큰수가 없으면 -1
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
