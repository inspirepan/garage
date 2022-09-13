package algorithm.C6;

import java.util.Arrays;

public class S673 {
    public int findNumberOfLIS(int[] nums) {
        // 最长严格递增子序列的个数
        // 300题中求了最长严格递增子序列的长度，现在这题要求数量，好难啊
        // 需要两个状态记录数组，一个记录包含nums[i]的递增子序列的最大长度，一个记录对应长度的数量

        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] dp = new int[len];
        int[] count = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxCount = 0;
        for (int i = 1; i < len; i++) {
            // 对于每一个数
            for (int j = 0; j < i; j++) {
                // 往前找可以接上的序列
                if (nums[i] > nums[j]) {
                    // 最大长度更新
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        // 当前长度，数量增加
                        count[i] += count[j];
                    }
                }
                if (dp[i] > maxCount) {
                    maxCount = dp[i];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (maxCount == dp[i]) {
                result += count[i];
            }
        }
        return result;
    }
}
