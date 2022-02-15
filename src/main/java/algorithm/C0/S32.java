package algorithm.C0;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最长有效括号子串长度
 * 最开始的思路，只将左括号入栈，做不出来，无法处理整个数组扫描完之后剩余的左括号
 */
public class S32 {
    public static int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int max = 0;
        int prevLength = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // 遇到的第一个右括号（把-1给用掉了）
                if (stack.isEmpty()) {
                    // 入栈保存这个无效的右括号位置
                    stack.push(i);
                } else {// 否则这个右括号是有效的，记录长度
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
