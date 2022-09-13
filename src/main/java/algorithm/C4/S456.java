package algorithm.C4;

import java.util.ArrayDeque;
import java.util.Deque;

public class S456 {
    public boolean find132pattern(int[] nums) {
        // 一个数左右各有一个比它小的，然后左边的还得比右边的小
        // 单调栈试试看
        // 一定要从右边往左边，做一个递减的单调栈
        if (nums.length < 3) {
            return false;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int a = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int c = nums[i];
            if (c < a) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < c) {
                a = stack.pop();
            }
            stack.push(c);
        }
        return false;
    }
}
