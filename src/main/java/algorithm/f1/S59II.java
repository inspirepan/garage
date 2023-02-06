package algorithm.f1;

import java.util.ArrayDeque;
import java.util.Deque;

public class S59II {
    class MaxQueue {
        private final Deque<Integer> queue = new ArrayDeque<>();
        private final Deque<Integer> max = new ArrayDeque<>();

        public MaxQueue() {

        }

        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return max.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!max.isEmpty() && max.peekLast() < value) {
                max.pollLast();
            }
            max.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int val = queue.poll();
            if (max.peek() == val) {
                max.poll();
            }
            return val;
        }
    }

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */

}
