package algorithm.C0;

import java.util.ArrayDeque;
import java.util.Deque;

public class S32 {

    class Solution {
        // 完全自己想出来的，还可以吧
        public int longestValidParentheses(String s) {
            int max = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            char[] arr = s.toCharArray();
            int i = 0;
            // 记录当前有效的左边界
            stack.push(-1);
            while (i < arr.length) {
                if (arr[i] == '(') {
                    stack.push(i);
                } else {
                    if (stack.size() > 1) {
                        int k = stack.pop();
                        max = Math.max(i - stack.peek(), max);
                    } else {
                        // stack.size()==1，更新左边界，因为多余的右括号是不可能再重新有效了
                        stack.pop();
                        stack.push(i);
                    }
                }
                i++;
            }
            return max;
        }
    }
}
