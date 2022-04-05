package algorithm.C2;

import java.util.ArrayDeque;
import java.util.Deque;

public class S255 {

    public boolean verifyPreorder(int[] preorder) {
        // 单调栈
        int len = preorder.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int currRootVal = Integer.MIN_VALUE;
        for (int j : preorder) {
            if (j < currRootVal) return false;
            while (!stack.isEmpty() && j > stack.peek()) {
                currRootVal = stack.pop();
            }
            stack.push(j);
        }
        return true;
    }
}
