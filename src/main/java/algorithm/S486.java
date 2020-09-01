package algorithm;

public class S486 {
    public boolean predictTheWinner(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        if (nums.length % 2 == 0) {
            return true;
        }
        /*
         * dp[i][j]dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，
         * 当前玩家与另一个玩家的分数之差的最大值，注意当前玩家不一定是先手
         */
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
