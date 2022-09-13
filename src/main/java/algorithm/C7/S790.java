package algorithm.C7;

public class S790 {
    public int numTilings(int n) {
        final int MOD = 1_000_000_007;
        long[][] dp = new long[n + 1][3];
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 5;
        }

        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[2][1] = 1;
        dp[2][2] = 1;
        for (int i = 3; i <= n; i++) {
            //
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 2][0]) % MOD;
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 2][0] + dp[i - 1][1]) % MOD;
        }
        return (int) dp[n][0];
    }

    class Solution {
        public int numTilings(int n) {
            final int MOD = 1_000_000_007;
            long[][] dp = new long[n + 1][2];
            if (n <= 2) {
                return n;
            }
            if (n == 3) {
                return 5;
            }

            dp[1][0] = 1;
            dp[2][0] = 2;
            dp[2][1] = 2;
            for (int i = 3; i <= n; i++) {
                //
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 2][0]) % MOD;
                dp[i][1] = (dp[i - 2][0] * 2 + dp[i - 1][1]) % MOD;
            }
            return (int) dp[n][0];
        }
    }
}
