package algorithm.C5;

/**
 * @author panjx
 */
public class S518 {
    public int change(int amount, int[] coins) {
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
}

