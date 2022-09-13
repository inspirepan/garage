package algorithm.c0;

import java.util.Deque;
import java.util.LinkedList;

public class S84 {

    /**
     * 实际上单个数组找到每一个元素前一个更小的元素并不需要用到栈！ 不需要找下一个，利用前面已经找好的，相当于dp
     */
    public int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        // 左边第一个比当前索引矮的
        int[] left = new int[len];
        // 右边第一个比当前索引矮的
        int[] right = new int[len];
        left[0] = -1;
        right[len - 1] = len;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            // 利用已经保存的left来寻找
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }
        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < len && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    /**
     * 单调栈
     */

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 每一个坐标i左边的第一个高度小于heights[i]的坐标
        int[] left = new int[len];
        int[] right = new int[len];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        int k = stack.size();
        while (k-- > 0) {
            left[stack.pop()] = -1;
        }
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        k = stack.size();
        while (k-- > 0) {
            right[stack.pop()] = len;
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}
