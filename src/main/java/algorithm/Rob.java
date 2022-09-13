package algorithm;

import java.util.Arrays;

/**
 * 打劫家舍
 */
public class Rob {

    /**
     * 198 I
     */
    public int rob1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 前i个家舍最多能打劫多少
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            // 打劫和不打劫两种情况
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    /**
     * 213 II
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 比打劫家舍I就多了一个限制条件，就是第一个和最后一个不能同时打劫
        // 分成两种情况考虑就是了
        return Math.max(rob2Helper(Arrays.copyOfRange(nums, 0, nums.length - 1)),
            rob2Helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int rob2Helper(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}

