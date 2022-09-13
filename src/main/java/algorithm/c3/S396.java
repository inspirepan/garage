package algorithm.c3;

public class S396 {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[0] += nums[i] * i;
            sum += nums[i];
        }
        int max = dp[0];
        // 数学规律题
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + sum - len * nums[len - i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
