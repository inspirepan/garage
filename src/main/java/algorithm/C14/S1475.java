package algorithm.C14;

import java.util.Deque;
import java.util.LinkedList;

public class S1475 {
    public int[] finalPrices(int[] prices) {
        // 下一个更小的元素，单调栈
        Deque<Integer> stack = new LinkedList<>();
        int[] discount = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            // 如果栈顶小于当前i处的值，就将继续入栈
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                // 当前栈顶坐标的值 大于等于 i处的值
                // 出栈
                discount[stack.peek()] = prices[i];
                stack.pop();
                System.out.println(stack);
            }
            stack.push(i);
        }
        for (int i = 0; i < discount.length; i++) {
            discount[i] = prices[i] - discount[i];
        }
        return discount;
    }
}
