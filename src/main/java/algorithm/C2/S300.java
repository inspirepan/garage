package algorithm.C2;

/**
 * @author panjx
 */
public class S300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int maxLen = 1;
        // dp定义为能够加入第i个数的最长子串长度
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int highest = 0;
            // 对于i之前的每一项，如果小于nums[i]，都可以成为上升子序列的一部分，因此求出最大值
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    highest = Math.max(highest, dp[j]);
                }
            }
            dp[i] = highest + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * 看的题解
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // tails的第i个表示在所有长度为i的上升子序列的末尾值中，最小的值
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int end = 0;
        for (int num : nums) {
            if (num > tails[end]) {
                tails[++end] = num;
            } else {
                int left = 0;
                int right = end;
                // 二分查找tails中第一个大于nums[i]的
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tails[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tails[left] = num;
            }
        }
        return ++end;
    }
}