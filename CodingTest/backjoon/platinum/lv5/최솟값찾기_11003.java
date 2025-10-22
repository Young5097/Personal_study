package backjoon.platinum.lv5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 해당 문제의 시간 제한은 2.4초이므로 N이 최대 5,000,000일때 정렬을 하면 (5,000,000)log(5,000,000) = 22정도 이므로 이후 연산 시 무조건 초과
public class 최솟값찾기_11003 {

    static class Node {
        int idx;
        int value;
        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int L = Integer.parseInt(st1.nextToken());
        
        Deque<Node> deque = new ArrayDeque<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int curValue = Integer.parseInt(st2.nextToken());
            Node node = new Node(i, curValue);

            while (!deque.isEmpty() && deque.getLast().value > curValue) { 
                deque.removeLast(); // Last는 Cur보다 작으므로 최솟값으로 선택될 일이 없음 -> 버림
            }

            deque.add(node);

            if (deque.getFirst().idx < i-L+1) { // 인덱스 범위가 현재 슬라이딩 윈도우를 벗어낫는지 확인
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        } 
    
        bw.flush();
        bw.close();
    }
}

/*
 * arr = [1, 5, 3, 7, 2, 8, 1], L = 3
 * 1) i = 0, num = 1
 *      deque = [ [0,1] ]
 * result = 1
 * 2) i = 1, num = 5
 *      deque = [ [0,1], [1,5] ]
 * result = 1
 * 3) i = 2, num = 3
 *      deque = [ [0,1], [2,3] ] -> [1,5]는 [2,3] 보다 작아서 앞으로 최솟값으로 선택될 일이 없음! 따라서 버림
 * result = 1
 * 4) i = 3, num = 7
 *      deque = [ [0,1], [2,5], [3, 7] ] 
 *      deque = [ [2,5], [3, 7] ] -> [0,1]번은 0 < 3(i)-3(L)+1 이므로 더이상 L에 포함될 수 없음(인덱스 슬라이딩 윈도우를 벗어남)
 * result = 3
 * ...
 */