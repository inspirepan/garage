package algorithm.F1;

import java.util.ArrayDeque;
import java.util.Deque;

public class S13 {
    final int[] dx = new int[] {-1, 1, 0, 0};
    final int[] dy = new int[] {0, 0, -1, 1};

    public int movingCount(int m, int n, int k) {
        int[][] board = new int[m][n];
        // 1 可以访问，检查可达性
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (checkDigit(x, y, k)) {
                    board[x][y] = 1;
                }
            }
        }
        int count = 1;
        // BFS
        board[0][0] = 2;
        Deque<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[] {0, 0});
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            int currX = curr[0], currY = curr[1];
            for (int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                if (newX >= 0 && newY >= 0 && newX < m && newY < n) {
                    if (board[newX][newY] == 1) {
                        board[newX][newY] = 2;
                        count++;
                        queue.offer(new Integer[] {newX, newY});
                    }
                }
            }
        }
        return count;
    }

    private boolean checkDigit(int i, int j, int k) {
        int sum = 0;
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum <= k;
    }
}
