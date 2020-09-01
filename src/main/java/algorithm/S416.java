package algorithm;

public class S416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == 0) {
            return true;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= 0; j--) {
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[target] != 0;
    }
}
