package algorithm.c0;

public class S64 {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;
        if (width == 0) {
            return 0;
        }
        for (int i = 1; i < height; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < width; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[height - 1][width - 1];
    }
}
