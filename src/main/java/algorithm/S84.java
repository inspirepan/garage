package algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 三种解法：单调栈、直观求解、粗暴分治
 */
public class S84 {

    /**
     * 单调栈
     */
    public int largestRectangleArea2(int[] heights) {
        // 保存索引
        var stack = new ArrayDeque<Integer>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() > 2 && stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty() && stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max;
    }

    /**
     * 这个太强了，从提交记录找的最快的2ms，思路是找到每个位置左右第一个比它矮的★
     */
    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        // 左边第一个比当前索引矮的
        int[] left = new int[n];
        // 右边第一个比当前索引矮的
        int[] right = new int[n];
        left[0] = -1;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                // jump to the first shorter height of index j
                j = left[j];
            }
            // set the first shorter height of index i = j
            left[i] = j;
        }
        System.out.println(Arrays.toString(left));
        right[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }
        System.out.println(Arrays.toString(right));
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }

    /**
     * 还是做不出来，分治
     */
    public int largestRectangleArea(int[] heights) {
        return helper(heights, 0, heights.length - 1);
    }

    private int helper(int[] h, int left, int right) {
        if (left > right) {
            return 0;
        }
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        // 主要是这一步比较慢，需要遍历整个数组
        for (int i = left; i <= right; i++) {
            if (minValue >= h[i]) {
                minValue = h[i];
                minIndex = i;
            }
        }
        return Math.max((right - left + 1) * minValue,
                Math.max(helper(h, left, minIndex - 1),
                        helper(h, minIndex + 1, right)));
    }
}
