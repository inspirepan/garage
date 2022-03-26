package algorithm.C3;

public class S338 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if (n == 0) return dp;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i >>> 1];
            } else {
                dp[i] = dp[i >>> 1] + 1;
            }
        }
        return dp;
    }
}
