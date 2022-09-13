package algorithm.c7;

public class S740 {
    public int deleteAndEarn(int[] nums) {
        // 选取任意个数，选取的数可以重复，但是不能有相邻的

        int[] t = new int[10001];
        for (int n : nums) {
            t[n] += n;
        }
        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = t[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + t[i]);
        }
        return dp[dp.length - 1];
    }
}
