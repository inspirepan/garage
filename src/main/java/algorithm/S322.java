package algorithm;

import java.util.Arrays;

public class S322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        int notFound = 99999;
        for (int i = 1; i <= amount; i++) {
            dp[i] = notFound;
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return (dp[amount] == notFound) ? -1 : dp[amount];
    }

}
