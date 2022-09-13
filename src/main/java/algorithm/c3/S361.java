package algorithm.c3;

public class S361 {
    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // 每个区间横向和纵向可以炸的人数
        for (int i = 0; i < m; i++) {
            int count = 0;
            int j = 0;
            int p = 0;
            while (j <= n) {
                if (j == n || grid[i][j] == 'W') {
                    while (p < j) {
                        if (grid[i][p] == '0') {
                            dp[i][p] = count;
                        }
                        p++;
                    }
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                }
                j++;
            }
        }
        for (int j = 0; j < n; j++) {
            int count = 0;
            int i = 0;
            int p = 0;
            while (i <= m) {
                if (i == m || grid[i][j] == 'W') {
                    while (p < i) {
                        if (grid[p][j] == '0') {
                            dp[p][j] += count;
                        }
                        p++;
                    }
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                }
                i++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
