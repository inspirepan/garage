package algorithm.C0;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        while (size-- > 1) {
            queue.offer(queue.poll());
        }
        assert queue.peek() != null;
        return queue.poll();
    }

    public int top() {
        int size = queue.size();
        if (size == 1) return queue.peek();
        int top = 0;
        while (size-- > 0) {
            queue.offer(queue.poll());
            if (size == 1) {
                assert queue.peek() != null;
                top = queue.peek();
            }
        }
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
