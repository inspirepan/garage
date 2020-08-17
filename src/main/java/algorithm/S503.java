package algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class S503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            int c = i % nums.length;
            while (!stack.isEmpty() && stack.peek() <= nums[c]) {
                stack.pop();
            }
            res[c] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[c]);
        }
        return res;
    }
}
