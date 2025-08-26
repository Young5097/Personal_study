package backjoon.silver.lv4;

/*
 * https://www.acmicpc.net/problem/10845
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 큐_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue queue = new 큐_10845().new Queue(n);

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                String[] parts = command.split(" ");
                int x = Integer.parseInt(parts[1]);
                queue.push(x);
            } else if (command.equals("pop")) {
                System.out.println(queue.pop());
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("empty")) {
                System.out.println(queue.empty());
            } else if (command.equals("front")) {
                System.out.println(queue.front());
            } else if (command.equals("back")) {
                System.out.println(queue.back());
            }
        }
    }

    class Queue {
        private int[] queue;
        private int head;
        private int tail;
        private int size;

        public Queue(int size) {
            this.queue = new int[size];
            this.head = 0;
            this.tail = 0;
            this.size = size;
        }

        public void push(int n) {
            queue[tail++] = n;
        }

        public int pop() {
            if (head == tail) {
                return -1;
            }
            return queue[head++];
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

        public int front() {
            if (head == tail) {
                return -1;
            }
            return queue[head];
        }

        public int back() {
            if (head == tail) {
                return -1;
            }
            return queue[tail - 1];
        }
    }
}