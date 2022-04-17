package algorithm.C1;

public class S188 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][1] = Integer.MIN_VALUE;
        }
        dp[0][0] = 0;
        for (int p : prices) {
            for (int i = k; i >= 1; i--) {
                dp[i][0] = Math.max(dp[i][0], dp[i][1] + p);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] - p);
            }
        }
        return dp[k][0];
    }
}
