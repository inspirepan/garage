package algorithm.C4;

public class S413 {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        // 末尾
        int[] dp = new int[len];
        int count = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
}
