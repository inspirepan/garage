package algorithm.C2;

import java.util.*;

/**
 * @author panjx
 */
public class S239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        // 单调队列 队首最大，队尾最小
        for (int i = 0; i < nums.length; i++) {
            // 先移除窗口之外的
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) queue.pollFirst();
            // 新来的和末尾最小的开始比起，踢掉不合格的
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            // 当前节点加入队列
            queue.offerLast(i);
            // 从第k-1个数开始，窗口达到了k，开始记录结果，最大的就是队列首部值
            if (i >= k - 1) result[i - k + 1] = nums[queue.peekFirst()];
        }
        return result;
    }
}
