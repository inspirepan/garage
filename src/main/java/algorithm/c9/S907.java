package algorithm.c9;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/13
 */
public class S907 {
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int len = arr.length;
            int MOD = 1000000007;
            // 左右第一个小于的
            var left = new int[len];
            var right = new int[len];
            Arrays.fill(left, -1);
            Arrays.fill(right, len);
            var stack = new ArrayDeque<Integer>();
            for (int i = 0; i < len; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    right[stack.pop()] = i;
                }
                if (!stack.isEmpty()) {
                    left[i] = stack.peek();
                }
                stack.push(i);
            }
            long result = 0;
            for (int i = 0; i < len; i++) {
                result = (result + (long) (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
            }

            return (int) result;
        }
    }
}
