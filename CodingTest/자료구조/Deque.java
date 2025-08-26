package 자료구조;

public class Deque {
    private int[] deque;
    private int head;
    private int tail;
    private static int SIZE = 1048576;

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

    private boolean isEmpty() {
        return head == tail;
    }
}
