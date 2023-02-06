package algorithm.c9;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S909 {
    class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            var t = new int[n * n + 1];
            int k = 1;
            int i = n - 1;
            int j = 0;
            boolean right = true;
            while (k <= n * n) {
                t[k++] = board[i][j];
                if (right ? ++j == n : --j == -1) {
                    --i;
                    j = right ? n - 1 : 0;
                    right = !right;
                }
            }
            // bfs
            var queue = new ArrayDeque<Integer>();
            var visited = new HashSet<Integer>();
            int times = 1;
            queue.offer(1);
            visited.add(1);
            while (true) {
                var nextQueue = new ArrayDeque<Integer>();
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    for (int l = 1; l < 7; l++) {
                        if (curr + l > n * n) {
                            break;
                        }
                        int next = t[curr + l] == -1 ? curr + l : t[curr + l];
                        if (curr + l == n * n || next == n * n) {
                            return times;
                        }
                        if (!visited.contains(next)) {
                            nextQueue.offer(next);
                        }
                        visited.add(next);
                    }
                }
                if (nextQueue.isEmpty()) {
                    return -1;
                }
                queue = nextQueue;
                times++;
            }
        }
    }
}
