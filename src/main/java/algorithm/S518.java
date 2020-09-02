package algorithm;

/**
 * @author panjx
 */
public class S518 {
    public int change2(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    dp[j] += dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

    /**
     * 动态规划
     *
     * @param amount 需求总和
     * @param coins  硬币种类
     * @return 组合方案数
     */
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        // 只使用前i种硬币，对于总数amount的解决方案数量
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
                if (i >= 1) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }
}

