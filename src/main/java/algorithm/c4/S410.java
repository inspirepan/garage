package algorithm.c4;

import java.util.Arrays;

public class S410 {
    public int splitArray(int[] nums, int m) {
        // 怎么抽象呢
        int len = nums.length;
        // 代表前i个数分割成j个非空连续子数组的和最大值中的最小值
        int[][] dp = new int[len + 1][m + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        // 起始条件 分割成一个
        int[] sum = new int[len + 1];
        int s = 0;
        for (int i = 0; i < len; i++) {
            s += nums[i];
            sum[i + 1] = s;
        }

        for (int i = 1; i <= len; i++) {
            int min = Math.min(m, i);
            for (int j = 1; j <= min; j++) {
                for (int k = 0; k < i; k++) {
                    // i中间再分割一段
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[len][m];
    }
}
