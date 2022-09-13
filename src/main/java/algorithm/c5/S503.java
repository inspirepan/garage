package algorithm.c5;

import java.util.Deque;
import java.util.LinkedList;

public class S503 {
    public int[] nextGreaterElements(int[] nums) {
        // 循环数组，复制一份数组就可以了
        // 单调栈
        int[] duplicate = new int[nums.length << 1];
        System.arraycopy(nums, 0, duplicate, 0, nums.length);
        System.arraycopy(nums, 0, duplicate, nums.length, nums.length);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < (nums.length << 1); i++) {
            while (!stack.isEmpty() && duplicate[stack.peek()] < duplicate[i]) {
                nums[stack.pop()] = duplicate[i];
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            nums[stack.pop()] = -1;
        }
        return nums;
    }
}
