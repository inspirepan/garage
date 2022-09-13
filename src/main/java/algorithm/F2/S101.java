package algorithm.F2;

public class S101 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >>> 1;
        // if exist subsequence of nums that sums == target
        for (int n : nums) {
            if (n == target) {
                return true;
            }
            if (n > target) {
                return false;
            }
        }

        // 01背包
        // 根本不是简单题啊
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int j = target; j >= 0; j--) {
                if (j >= n) {
                    dp[j] += dp[j - n];
                }
            }
        }
        return dp[target] != 0;
    }
}
