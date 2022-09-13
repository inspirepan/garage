package algorithm.c3;

public class S375 {
    public int getMoneyAmount(int n) {
        // 确保获胜的最小现金数
        // 不一定是二分策略
        // dp i j 表示从区间[i,j]中猜到结果的最少花费
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; --i) {
            for (int j = i; j <= n; ++j) {
                // [i, j]
                if (i == j) {
                    dp[i][j] = 0;
                } else if (i + 2 == j) {
                    dp[i][j] = i + 1;
                } else if (i + 1 == j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int x = i; x <= j; ++x)
                    // 不是很懂什么时候建立的初始值
                    {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][x - 1], dp[x + 1][j]) + x);
                    }
                }
            }
        }
        return dp[1][n];
    }
}
