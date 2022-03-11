package algorithm.C4;

public class S494 {
    private int sum1 = 0;
    private int count1 = 0;

    public int findTargetSumWays(int[] nums, int target) {
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

    public int findTargetSumWays2(int[] nums, int S) {
        // 动态规划
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum < S || ((sum + S) & 1) == 1) {
            return 0;
        }
        int t = (sum + S) >> 1;
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = t; j >= 0; j--) {
                if (j >= num) {
                    /* 两种选择，要么加上这个数，要么不加上。
                     * 不加上不会改变当前的和，因此 dp[j] = dp[j]
                     * 加上的话，就要再记上dp[j-nums[i-1]]的方法数 */
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[t];
    }
}
