package algorithm.c3;

public class S300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int end = 0;
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[end]) {
                dp[++end] = nums[i];
            } else {
                // 往前找第一个大于的位置
                // 因为是有序的，所以优化成二分
                int k = end;
                while (k >= 0 && dp[k] >= nums[i]) {
                    k--;
                }
                dp[k + 1] = nums[i];
            }
        }
        return end + 1;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int end = 0;
        for (int num : nums) {
            if (num > dp[end]) {
                dp[++end] = num;
            } else {
                int left = 0;
                int right = end;
                // 二分查找tails中第一个大于nums[i]的
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (dp[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = num;
            }
        }
        return ++end;
    }
}