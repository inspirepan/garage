package algorithm.C4;

public class S416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum == 0) return true;
        if ((sum & 1) != 0) return false;
        int target = sum >> 1;
        // 能否取出任意个数使得和等于target
        // dp[i]大于0表示可以被表示为数组中的任意个数之和
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
