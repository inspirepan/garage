package algorithm.F1;

import java.util.ArrayDeque;
import java.util.Deque;

public class S59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        for (int i = k - 1; i < len; i++) {
            while (!queue.isEmpty() && i - queue.peek() >= k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            result[i - k + 1] = nums[queue.peek()];
        }
        return result;
    }
}
