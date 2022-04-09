package algorithm.C3;

public class S329 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        // 用dfs写比较简单，因为dfs可以返回一个数值
        // bfs写比较麻烦，还要回溯
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int x, int y, int[][] dp) {
        // searched
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        // at least 1
        dp[x][y] = 1;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n)
                if (matrix[nx][ny] > matrix[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(matrix, nx, ny, dp) + 1);
                }
        }
        return dp[x][y];
    }
}
