package algorithm.c9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S934 {

    class Solution {
        static final int[] dirX = new int[]{1, 0, -1, 0};
        static final int[] dirY = new int[]{0, -1, 0, 1};

        public int shortestBridge(int[][] grid) {
            // 先染色成2
            Deque<int[]> sea = new LinkedList<>();
            int n = grid.length;
            outter:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j, sea);
                        break outter;
                    }
                }
            }
            // 距离
            int res = 1;
            while (!sea.isEmpty()) {
                int size = sea.size();
                for (int i = 0; i < size; i++) {
                    int[] curr = sea.poll();
                    int x = curr[0];
                    int y = curr[1];
                    for (int j = 0; j < 4; j++) {
                        int nx = x + dirX[j];
                        int ny = y + dirY[j];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if (grid[nx][ny] == 1) {
                                return res;
                            } else if (grid[nx][ny] == 0) {
                                sea.offer(new int[]{nx, ny});
                                grid[nx][ny] = 2;
                            }
                        }
                    }
                }
                res++;
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j, Deque<int[]> sea) {
            if (i < 0 || j < 0 || grid.length <= i || grid.length <= j) {
                return;
            }
            if (grid[i][j] == 0) {
                grid[i][j] = 2;
                sea.offer(new int[]{i, j});
            } else if (grid[i][j] == 1) {
                grid[i][j] = 2;
                for (int k = 0; k < 4; k++) {
                    dfs(grid, i + dirX[k], j + dirY[k], sea);
                }
            }
        }
    }

    class Solution2 {

        static final int[] dirX = new int[]{1, 0, -1, 0};
        static final int[] dirY = new int[]{0, -1, 0, 1};

        public static int shortestBridge(int[][] grid) {
            // 先染色成2
            var queue = new ArrayDeque<int[]>();
            var sea = new ArrayDeque<int[]>();
            int n = grid.length;
            outter:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 2;
                        queue.offer(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] curr = queue.poll();
                            int x = curr[0];
                            int y = curr[1];
                            for (int k = 0; k < 4; k++) {
                                int nx = x + dirX[k];
                                int ny = y + dirY[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                    if (grid[nx][ny] == 1) {
                                        grid[nx][ny] = 2;
                                        queue.offer(new int[]{nx, ny});
                                    } else if (grid[nx][ny] == 0) {
                                        grid[nx][ny] = 2;
                                        sea.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                        break outter;
                    }
                }
            }
            // 距离
            int res = 1;
            while (!sea.isEmpty()) {
                int size = sea.size();
                for (int i = 0; i < size; i++) {
                    int[] curr = sea.poll();
                    int x = curr[0];
                    int y = curr[1];
                    for (int j = 0; j < 4; j++) {
                        int nx = x + dirX[j];
                        int ny = y + dirY[j];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            if (grid[nx][ny] == 1) {
                                return res;
                            } else if (grid[nx][ny] == 0) {
                                sea.offer(new int[]{nx, ny});
                                grid[nx][ny] = 2;
                            }
                        }
                    }
                }
                res++;
            }
            return res;
        }
    }
}