package algorithm.C6;

public class S634 {

    public int findDerangement(int n) {
        long[] dp = new long[n + 1];
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        dp[1] = 0;
        dp[2] = 1;
        final int MOD = 1000000007;
        for (int i = 3; i <= n; i++) {
            // i-1的完全错位，可以将i随便i-1个互换，或者和1个在原位的互换
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % MOD;
        }
        return (int) dp[n];
    }

    public int findDerangement2(int n) {
        long MOD = 1000000007;
        long prev1 = 1, prev2 = 0;
        for (int i = 2; i <= n; i++) {
            long c = ((i - 1) * (prev1 + prev2)) % MOD;
            prev1 = prev2;
            prev2 = c;
        }
        return (int) prev2;
    }
}
