package algorithm.S201to300;

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
                assert queue.peekFirst() != null;
                res[i - k + 1] = queue.peekFirst();
                /*
                 * 可以理解为一个能快速给出最大值的固定k长度的队列，
                 * 本来我们每一轮循环，都要在队列尾加入nums[i]，都要把队列头部的那个值poll出，
                 * 但是因为实现单调队列已经提前把小元素poll掉了，所以实际操作poll元素的时候是根据数值大小来判断的。
                 */
                if (queue.peekFirst() == nums[i - k + 1]) {
                    queue.pollFirst();
                }
            }
        }
        return res;
    }
}
