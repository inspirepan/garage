package algorithm.c2;

public class S276 {
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 2) {
            return k * k;
        }
        // 0 代表当前位置与上一个颜色不同的方案数量
        // 1 代表当前位置与上一个颜色相同的方案数量
        int[][] dp = new int[n][2];
        dp[0][0] = k;
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (k - 1) * (dp[i - 1][0] + dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0];
        }
        return dp[n - 1][1] + dp[n - 1][0];
    }
}
