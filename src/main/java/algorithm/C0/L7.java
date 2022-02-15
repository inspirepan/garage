package algorithm.C0;

public class L7 {
    public int numWays(int n, int[][] relation, int k) {
        // 动态规划 dp[][]表示第i步到第j处的方法数
        if (k == 0 || n == 0) return 0;
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;

        for (int i = 1; i < k + 1; i++) {
            // 第i步
            for (int[] re : relation) {
                int source = re[0];
                int target = re[1];
                dp[i][target] += dp[i - 1][source];
            }
        }

        return dp[k][n - 1];
    }
}
