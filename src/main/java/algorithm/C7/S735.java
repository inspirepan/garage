package algorithm.C7;

import java.util.ArrayDeque;
import java.util.Deque;

public class S735 {
    public int[] asteroidCollision(int[] asteroids) {
        // 左边正的和右边负的相撞，保留大的，相同则不保留
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : asteroids) {
            if (i > 0) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -i) {
                    // 比i小的全部爆炸
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() == -i) stack.pop(); // 一样大，爆炸
                    // 否则保留peek的行星
                } else {
                    // 否则添加i
                    stack.push(i);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
