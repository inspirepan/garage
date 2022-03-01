package algorithm.C3;

import java.util.Stack;

public class S316 {
    public String removeDuplicateLetters(String s) {
        // 统计每个字母出现的位置？
        // 那么如何确定最小字母序呢
        // 看了相关标签，怎么这种题目都是单调栈啊
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // 如果已经有了这个字符
            if (stack.contains(c))
                continue;
            // 新字符，如果栈顶字符比新字符大，并且栈顶的字符在之后还会出现，那么抛弃栈顶字符
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1)
                stack.pop();
            // 新字符入栈
            stack.push(c);
        }
        // 重新组装成字符串
        char chars[] = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }
}
