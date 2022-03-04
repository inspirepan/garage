package algorithm.C3;

public class S357 {

    /**
     * f(0)=1
     * f(1)=10
     * f(2)=9*9+f(1)
     * f(3)=9*9*8+f(2)
     * f(4)=9*9*8*7+f(3)
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int ans = 10;
        for (int i = 1; i < Math.min(10, n); i++) {
            dp[i + 1] = dp[i] * (10 - i);
            ans += dp[i + 1];
        }
        return ans;
    }
}

