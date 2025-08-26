package 자료구조;

public class Stack {
    private Object[] stack;
    private int top; // 스택 맨 위 원소의 인덱스
    private static final int DEFAULT_SIZE = 10;

    public Stack() {
        stack = new Object[DEFAULT_SIZE];
        top = -1;
    }

    public Stack(int size) {
        stack = new Object[size];
        top = -1;
    }

    public void push(Object item) {
        if (top == stack.length - 1) {
            expandSize();
        }

        stack[++top] = item;
    }

    public Object pop() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }

        return stack[top--];
    }

    public Object peek() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty");
        }

        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    private void expandSize() {
        Object[] newStack = new Object[stack.length * 2];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
}