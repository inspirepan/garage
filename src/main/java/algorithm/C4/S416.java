package algorithm.C4;

import java.util.Arrays;

public class S416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) return false;
        int target = sum >>> 1;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = target; i - n >= 0; i--) {
                if (dp[i - n]) dp[i] = true;
            }
        }
        return dp[target];
    }
}
