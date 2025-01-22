class MyStack {
    private int[] stack;
    private int top;
    private int capacity;

    MyStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int val) {
        if (top == capacity - 1) return;
        stack[++top] = val;
    }

    public int pop() {
        if (top == -1) return -1;
        return stack[top--];
    }

    public int peek() {
        if (top == -1) return -1;
        return stack[top];
    }
}

public class Q3 {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
