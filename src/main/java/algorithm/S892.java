package algorithm;

public class S892 {
    public int surfaceArea(int[][] grid) {
        int count = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int h = grid[i][j];
                // 上下面
                if (h > 0) count += 2;
                // 四周
                if (i == 0) count += h;
                else if (grid[i - 1][j] < h) count += h - grid[i - 1][j];

                if (j == 0) count += h;
                else if (grid[i][j - 1] < h) count += h - grid[i][j - 1];

                if (i == n - 1) count += h;
                else if (grid[i + 1][j] < h) count += h - grid[i + 1][j];

                if (j == n - 1) count += h;
                else if (grid[i][j + 1] < h) count += h - grid[i][j + 1];
            }
        }
        return count;
    }
}
