package algorithm.c3;

import java.util.ArrayDeque;
import java.util.Deque;

public class S394 {
    public String decodeString(String s) {
        int i = 0;
        char[] arr = s.toCharArray();
        Deque<Integer> timeStack = new ArrayDeque<>();
        Deque<StringBuilder> sbStack = new ArrayDeque<>();
        sbStack.push(new StringBuilder());
        while (i < arr.length) {
            char c = arr[i];
            // 遇到数字直接入栈
            if (c <= '9' && c >= '0') {
                int p = i;
                while (i < arr.length && arr[i] <= '9' && arr[i] >= '0') {
                    i++;
                }
                timeStack.push(Integer.parseInt(s.substring(p, i)));
                sbStack.push(new StringBuilder());
            } else if (c >= 'a' && c <= 'z') {
                // 遇到字符
                sbStack.peek().append(c);
            } else if (c == ']') {
                int times = timeStack.pop();
                var lastSb = sbStack.pop();
                sbStack.peek().append(lastSb.toString().repeat(times));
            }
            i++;
        }
        return sbStack.peek().toString();
    }
}
