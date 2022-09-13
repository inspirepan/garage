package algorithm.c5;

import java.util.ArrayDeque;
import java.util.Deque;

public class S581 {
    public int findUnsortedSubarray(int[] nums) {
        // 两个单调栈，找左起每一个元素下一个更小的元素，右起每一个元素下一个更大的元素
        Deque<Integer> stack = new ArrayDeque<>();
        // 找到第一个有更小元素的下标
        int min = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                min = Math.min(min, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                max = Math.max(max, stack.pop());
            }
            stack.push(i);
        }
        if (max <= min) {
            return 0;
        }
        return max - min + 1;
    }
}
