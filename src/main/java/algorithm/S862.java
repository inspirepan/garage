package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S862 {
    class Solution {
        // 前缀和+单调栈+二分搜索，有一个例子做不出来不知道为什么，数组越界了
        public int shortestSubarray(int[] nums, int k) {
            int len = nums.length;
            long[] sum = new long[len + 1];
            int s = 0;
            for (int i = 0; i < len; i++) {
                s += nums[i];
                sum[i + 1] = s;
            }
            int res = Integer.MAX_VALUE;
            List<Integer> stack = new ArrayList<>();

            for (int i = 0; i <= len; i++) {

                while (!stack.isEmpty() && sum[stack.get(stack.size() - 1)] > sum[i]) {
                    stack.remove(stack.size() - 1);
                }
                if (!stack.isEmpty()) {
                    // 求当前stack中第一个小于nums[i]-k的
                    int left = 0;
                    int right = stack.size();

                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (sum[i] - sum[stack.get(mid)] < k) {
                            right = mid;
                        } else {
                            left = mid + 1;
                        }
                    }
                    if (--left >= 0) {
                        res = Math.min(i - stack.get(left), res);
                    }
                }
                stack.add(i);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
