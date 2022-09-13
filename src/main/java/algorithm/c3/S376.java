package algorithm.c3;

public class S376 {
    public int wiggleMaxLength(int[] nums) {
        // 单纯双重循环dp效率很低，好像效果不太好，可以考虑剪枝?
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int[][] dp = new int[len][2];
        // 对于dp[i] 表示加入nums[i]后的子序列最长长度，分成两种，一种是nums[i]位于谷，另一种是位于峰
        int max = 0;

        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            int vali = nums[i];
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int k = i - 1; k >= 0; k--) {
                int valk = nums[k];
                if (valk > vali) {
                    dp[i][0] = Math.max(dp[i][0], dp[k][1] + 1);
                    max = Math.max(max, dp[i][0]);
                } else if (valk < vali) {
                    dp[i][1] = Math.max(dp[i][1], dp[k][0] + 1);
                    max = Math.max(max, dp[i][1]);
                }
            }
        }
        return max;
    }

    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
