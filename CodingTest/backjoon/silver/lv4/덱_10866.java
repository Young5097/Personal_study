package backjoon.silver.lv4;

/*
 * https://www.acmicpc.net/problem/10866
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 덱_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque deque = new 덱_10866().new Deque();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push_front")) {
                String[] parts = command.split(" ");
                int x = Integer.parseInt(parts[1]);
                deque.push_front(x);
            } else if (command.startsWith("push_back")) {
                String[] parts = command.split(" ");
                int x = Integer.parseInt(parts[1]);
                deque.push_back(x);
            } else if (command.equals("pop_front")) {
                System.out.println(deque.pop_front());
            } else if (command.equals("pop_back")) {
                System.out.println(deque.pop_back());
            } else if (command.equals("size")) {
                System.out.println(deque.size());
            } else if (command.equals("empty")) {
                System.out.println(deque.empty());
            } else if (command.equals("front")) {
                System.out.println(deque.front());
            } else if (command.equals("back")) {
                System.out.println(deque.back());
            }
        }
    }

    class Deque {
        private int[] deque;
        private int head;
        private int tail;
        private int SIZE = 1048576;

        public Deque() {
            this.deque = new int[2 * SIZE + 1];
            this.head = SIZE;
            this.tail = SIZE;
        }

        public void push_front(int n) {
            deque[--head] = n;
        }

        public void push_back(int n) {
            deque[tail++] = n;
        }

        public int pop_front() {
            if (isEmpty()) {
                return -1;
            }
            return deque[head++];
        }

        public int pop_back() {
            if (isEmpty()) {
                return -1;
            }
            return deque[--tail];
        }

        public int front() {
            if (isEmpty()) {
                return -1;
            }
            return deque[head];
        }

        public int back() {
            if (isEmpty()) {
                return -1;
            }
            return deque[tail - 1];
        }

        public int size() {
            return tail - head;
        }

        public int empty() {
            if (head == tail) {
                return 1;
            }
            return 0;
        }

        private boolean isEmpty() {
            return head == tail;
        }
    }
}