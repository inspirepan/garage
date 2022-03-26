package algorithm.F1;

import java.util.ArrayDeque;
import java.util.Deque;

public class S31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 模拟栈操作
        if (pushed.length != popped.length) return false;
        int len = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (i < len) {
            while (i < len && pushed[i] != popped[j]) {
                stack.push(pushed[i]);
                i++;
            }
            // pushed i == popped j
            if (i != len) {
                stack.push(pushed[i]);
                i++;
            }
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
