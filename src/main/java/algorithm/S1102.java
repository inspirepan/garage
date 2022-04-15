package algorithm;

import java.util.ArrayList;
import java.util.List;

public class S1102 {

    int max = 0;
    int[][] grid;
    int m;
    int n;
    int[] dx = new int[]{-1, 0, 0, 1};
    int[] dy = new int[]{0, 1, -1, 0};

    public int maximumMinimumPath(int[][] grid) {
        // 分数是这个路径上的最小值
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dfs(0, 0, Math.min(grid[0][0], grid[m - 1][n - 1]));
        return max;
    }

    void dfs(int x, int y, int currMin) {
        if (x == m - 1 && y == n - 1) {
            max = Math.max(max, currMin);
            return;
        }
        int t = grid[x][y];
        grid[x][y] = -2;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (grid[nx][ny] >= 0) {
                    dfs(nx, ny, Math.min(currMin, grid[nx][ny]));
                }
            }
        }
        grid[x][y] = t;
    }
}
