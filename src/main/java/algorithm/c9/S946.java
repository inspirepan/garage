package algorithm.c9;

import java.util.ArrayDeque;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S946 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int j = 0;
            var stack = new ArrayDeque<Integer>();
            int len = pushed.length;
            for (int i = 0; i < len; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();

        }
    }
}
