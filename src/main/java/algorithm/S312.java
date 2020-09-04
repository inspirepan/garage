package algorithm;

/**
 * @author panjx
 */
public class S312 {
    /**
     * 戳气球
     *
     * @param nums 戳破获得 nums[left] * nums[i] * nums[right]
     * @return 求最大获得可能
     */
    public static int maxCoins(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] n = new int[length + 2];
        n[0] = 1;
        n[length + 1] = 1;
        System.arraycopy(nums, 0, n, 1, nums.length);

        // 戳破气球i到j（去边）能够得到的最高分数
        int[][] dp = new int[length + 2][length + 2];
        // 从选中气球数开始递增，先考虑两个球
        for (int i = 2; i <= length + 1; i++) {
            for (int s = 0; s <= length + 1 - i; s++) {
                for (int k = s + 1; k < s + i; k++) {
                    // 选择一个中间球作为最后被戳破的球，那么他的得分就是两段被戳破的球组合的最大得分和，加上两端的球与该球乘积
                    int split = n[k] * n[s] * n[s + i] + dp[s][k] + dp[k][s + i];
                    dp[s][s + i] = Math.max(dp[s][s + i], split);
                }
            }
        }
        return dp[0][length + 1];
    }
}
