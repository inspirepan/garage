package algorithm.C14;

import java.util.Comparator;
import java.util.PriorityQueue;

public class S1438 {
    public int longestSubarray(int[] nums, int limit) {
        // 滑动窗口？
        // 从2到nums.length的窗口，看每个窗口的最大绝对差中取最小
        // 不能就是呆算，会超时
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < nums.length && left < nums.length) {
            minQueue.add(nums[right]);
            maxQueue.add(nums[right]);
            // 队首的就是最大值和最小值
            if (maxQueue.peek() - minQueue.peek() <= limit) {
                // 当前窗口大小
                ans = Math.max(ans, right - left + 1);
                // 扩大窗口
                right++;
                continue;
            }
            // 移出左边的数
            maxQueue.remove((Integer) nums[left]);
            minQueue.remove((Integer) nums[left]);
            left++;
            right++;
        }
        return ans;
    }
}
