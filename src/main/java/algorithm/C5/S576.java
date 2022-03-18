package algorithm.C5;

public class S576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // 移动n次可以出界的路线
        // 动态规划题
        final int MOD = 1000000007;
        final int[] dx = new int[]{-1, 1, 0, 0};
        final int[] dy = new int[]{0, 0, 1, -1};
        // 表示i，j在k步内可以出界的路径数
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int k = 1; k <= maxMove; k++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) dp[x][y][k]++;
                        else dp[x][y][k] = (dp[x][y][k] + dp[nx][ny][k - 1]) % MOD;
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}
