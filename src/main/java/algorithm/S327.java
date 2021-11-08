package algorithm;

import java.util.Arrays;

public class S327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        // 表示区间和S(i,j)
        long[][] dp = new long[len][len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
            if (nums[i] >= lower && nums[i] <= upper) count++;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];
                if (dp[i][j] >= lower && dp[i][j] <= upper) count++;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return count;
    }
}
