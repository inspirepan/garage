package algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class S1475 {
    // 下一个更小的元素，比单调栈快
    // 85题评论看到过的，之前没记住
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] right = new int[len];
        right[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < len && prices[j] > prices[i]) {
                j = right[j];
            }
            right[i] = j;
        }
        for (int i = 0; i < len; i++) {
            int nextIndex = right[i];
            if (nextIndex == len) right[i] = prices[i];
            else right[i] = prices[i] - prices[nextIndex];
        }
        return right;
    }

    // 单调栈
    public int[] finalPrices2(int[] prices) {
        Deque<Integer> stack = new LinkedList<>();
        int len = prices.length;
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                right[stack.peek()] = prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = prices[i] - right[i];
        }
        return right;
    }
}
