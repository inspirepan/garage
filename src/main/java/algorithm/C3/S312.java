package algorithm.C3;

/**
 * @author panjx
 */
public class S312 {

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
        // 戳破气球的数量+1 （用于确定右端点，i=2代表戳破一个气球）
        for (int i = 2; i <= length + 1; i++) {
            // 选中区间的左边
            for (int s = 0; s <= length + 1 - i; s++) {
                // 这段区间最后一个被戳破的气球，如果i==2代表只有一个气球
                for (int k = s + 1; k < s + i; k++) {
                    int split = n[k] * n[s] * n[s + i] + dp[s][k] + dp[k][s + i];
                    dp[s][s + i] = Math.max(dp[s][s + i], split);
                }
            }
        }
        // 最终状态一定是只留下两端虚拟气球的
        return dp[0][length + 1];
    }

    class Solution {
        // 4.25自己独立写的
        public int maxCoins(int[] nums) {
            int len = nums.length;
            int[][] dp = new int[len + 2][len + 2];
            int[] b = new int[len + 2];
            b[0] = 1;
            b[len + 1] = 1;
            System.arraycopy(nums, 0, b, 1, len);
            for (int i = 1; i <= len; i++) {
                dp[i - 1][i + 1] = b[i] * b[i - 1] * b[i + 1];
            }

            for (int k = 2; k <= len; k++) {
                for (int i = 0; i + k <= len; i++) {
                    int temp = 0;
                    for (int j = i + 1; j <= i + k; j++) {
                        temp = Math.max(temp, b[j] * b[i] * b[i + k + 1] + dp[i][j] + dp[j][i + k + 1]);
                    }
                    dp[i][i + k + 1] = temp;
                }
            }
            return dp[0][len + 1];
        }
    }
}
