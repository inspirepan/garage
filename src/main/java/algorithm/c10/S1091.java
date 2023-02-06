package algorithm.c10;

import java.util.LinkedList;
import java.util.Queue;

public class S1091 {
    int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return -1;
        }
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 2;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int k = 0; k < 8; k++) {
                    int nx = curr[0] + dx[k];
                    int ny = curr[1] + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 0) {
                        if (nx == n - 1 && ny == n - 1) {
                            return step;
                        }
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
