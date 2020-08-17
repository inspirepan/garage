package algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class S232 {

}

class MyQueue {

    Deque<Integer> s1 = new LinkedList<>();
    Deque<Integer> s2 = new LinkedList<>();

    public MyQueue() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int t = 0;
        do {
            t = s1.pop();
            if (!s1.isEmpty()) {
                s2.push(t);
            } else {
                break;
            }
        } while (true);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return t;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int t = 0;
        while (!s1.isEmpty()) {
            t = s1.pop();
            s2.push(t);
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return t;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return this.s1.isEmpty();
    }
}
