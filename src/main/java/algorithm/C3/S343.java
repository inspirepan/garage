package algorithm.C3;

import java.util.Arrays;

public class S343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int j = i - 1;
            while (j >= 1) {
                // 因为必须要拆分成两个，所以dp[i]不一定大于i
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
                j--;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
