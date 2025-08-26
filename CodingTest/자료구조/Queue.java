package 자료구조;

public class Queue {
    private Object[] queue;
    private int head;
    private int tail;
    private int size;

    public Queue(int size) {
        this.queue = new Object[size];
        this.head = 0;
        this.tail = 0;
        this.size = size;
    }

    public void push(Object item) {
        if (tail == size) {
            expandSize();
        }
        queue[tail++] = item;
    }

    public Object front() {
        if (head == tail) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[head];
    }

    public Object back() {
        if (head == tail) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[tail - 1];
    }

    public Object pop() {
        if (head == tail) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[head++];
    }

    private void expandSize() {
        Object[] newQueue = new Object[queue.length * 2];
        for (int i = 0; i < queue.length; i++) {
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }

}
