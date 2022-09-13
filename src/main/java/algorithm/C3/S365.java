package algorithm.C3;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class S365 {
    // 求最大公约数，是否可以整除target
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        while (x != y) {
            if (x > y) {
                x -= y;
            } else {
                y -= x;
            }
        }
        return target % x == 0;
    }

    //模拟每一个操作，用一个栈进行广度优先搜索，然后用一个Set来剪枝
    public boolean canMeasureWater2(int x, int y, int z) {
        Deque<int[]> stack = new LinkedList<int[]>();
        stack.push(new int[] {0, 0});
        Set<Long> visited = new HashSet<Long>();
        while (!stack.isEmpty()) {
            if (visited.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            visited.add(hash(stack.peek()));

            int[] state = stack.pop();
            int rx = state[0], ry = state[1];
            if (rx == z || ry == z || rx + ry == z) {
                return true;
            }
            // 把 X 壶灌满
            stack.push(new int[] {x, ry});
            // 把 Y 壶灌满
            stack.push(new int[] {rx, y});
            // 把 X 壶倒空
            stack.push(new int[] {0, ry});
            // 把 Y 壶倒空
            stack.push(new int[] {rx, 0});
            // 把 X 壶的水灌进 Y 壶，直至灌满或倒空
            stack.push(new int[] {rx - Math.min(rx, y - ry), ry + Math.min(rx, y - ry)});
            // 把 Y 壶的水灌进 X 壶，直至灌满或倒空
            stack.push(new int[] {rx + Math.min(ry, x - rx), ry - Math.min(ry, x - rx)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }
}
