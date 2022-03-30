package algorithm.F2;

import java.util.Arrays;

public class S104 {


    public int combinationSum4(int[] nums, int target) {
        // 正确答案，把值的遍历放在外圈、数字遍历放在内圈，
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (n <= i) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }

    public int combinationSumNOT(int[] nums, int target) {
        // 这样子是相同顺序的
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            int k = n;
            while (k <= target) {
                dp[k] += dp[k - n];
                k++;
            }
        }
        return dp[target];
    }
}
