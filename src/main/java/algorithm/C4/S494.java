package algorithm.C4;

public class S494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        target += sum;
        if (target < 0) return 0;
        if ((target & 1) == 1) return 0;
        target /= 2;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int k = target; k >= n; k--) {
                dp[k] += dp[k - n];
            }
        }
        return dp[target];
    }

    private int sum1 = 0;
    private int count1 = 0;

    public int findTargetSumWays2(int[] nums, int target) {
        // dfs全部情况
        dfs(nums, target, 0);
        return count1;
    }

    private void dfs(int[] nums, int target, int pos) {
        if (pos == nums.length) {
            if (sum1 == target) {
                count1++;
            }
            return;
        }
        sum1 += nums[pos];
        dfs(nums, target, pos + 1);
        sum1 -= 2 * nums[pos];
        dfs(nums, target, pos + 1);
        sum1 += nums[pos];
    }
}
