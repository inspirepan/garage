package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author panjx
 */
public class S239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = queue.peekFirst();
                if (!queue.isEmpty() && queue.peekFirst() == nums[i - k + 1]) {
                    queue.pollFirst();
                }
            }
        }
        return res;
    }
}
