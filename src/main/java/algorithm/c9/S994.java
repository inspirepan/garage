package algorithm.c9;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author : panjixiang
 * @since : 2022/11/14
 */
public class S994 {

    private static final int[] dx = new int[]{1, -1, 0, 0};
    private static final int[] dy = new int[]{0, 0, 1, -1};

    class Solution {
        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                    }
                    grid[i][j] = -grid[i][j];
                }
            }
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] curr = queue.poll();
                    for (int i1 = 0; i1 < 4; i1++) {
                        int x = curr[0] + dx[i1];
                        int y = curr[1] + dy[i1];
                        if (x >= m || y >= n || x < 0 || y < 0) {
                            continue;
                        }
                        if (grid[x][y] == -1) {
                            queue.offer(new int[]{x, y});
                            grid[x][y] = step + 1;
                        }
                    }
                }
                if (!queue.isEmpty()) {
                    step++;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == -1) {
                        return -1;
                    }
                }
            }
            System.out.println(Arrays.deepToString(grid));
            return step;
        }
    }
}
