package algorithm.F2;

public class S102 {
    public int findTargetSumWays(int[] nums, int target) {
        // 还是可以转换成01背包问题!
        // 取-的时候认为是0.取+的时候认为是*2再+
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int[] dp = new int[target + sum + 1];
        dp[0] = 1;
        for (int n : nums) {
            int j = target + sum;
            while (j >= (n << 1)) {
                dp[j] += dp[j - (n << 1)];
                j--;
            }
        }
        return dp[target + sum];
    }
}
