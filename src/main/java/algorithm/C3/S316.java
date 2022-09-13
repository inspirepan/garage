package algorithm.C3;

import java.util.ArrayDeque;
import java.util.Deque;

public class S316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        // 统计每一个字符的出现数量
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            // 不要重复入栈，因为是单调栈，如果已经有了，那重复入栈会把后面的给挤掉
            if (!stack.contains(c)) {
                // 当栈顶的元素还有余并且字母序大于当前c的时候，出栈
                while (!stack.isEmpty() && count[stack.peek() - 'a'] > 0 && stack.peek() > c) {
                    stack.pop();
                }
                stack.push(c);
            }
            count[c - 'a']--;
        }

        var sb = new StringBuilder();
        // 注意for循环的stack也是pop()顺序的
        for (char c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
