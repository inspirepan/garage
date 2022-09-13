package algorithm.F2;

import java.util.Arrays;

public class S103 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int n : coins) {
            if (n > amount) {
                continue;
            }
            if (n == amount) {
                return 1;
            }
            int k = n;
            while (k <= amount) {
                if (dp[k - n] < dp[k] - 1) {
                    dp[k] = dp[k - n] + 1;
                }
                // 等价于 min(dp[k], dp[k-n]+1，但是要防止出界
                k++;
            }
        }
        int res = dp[amount];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
