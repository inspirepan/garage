package algorithm.C8;

public class S877 {

    //自己写的动态规划
    class Solution {
        public boolean stoneGame(int[] piles) {
            int len = piles.length;
            // 剩余i,j区间石子时的胜负情况
            int[][][] dp = new int[len][len][2];
            for (int i = 0; i < len; i++) {
                dp[i][i][0] = piles[i];
            }
            for (int s = 1; s < len; s++) {
                for (int i = 0; i + s < len; i++) {
                    int left = dp[i + 1][i + s][1] + piles[i];
                    int right = dp[i][i + s - 1][1] + piles[i + s];
                    dp[i][i + s][0] = Math.max(left, right);
                    // 注意后手是被动的，要根据先手的选择
                    if (left > right) {
                        dp[i][i + s][1] = dp[i + 1][i + s][0];
                    } else {
                        dp[i][i + s][1] = dp[i][i + s - 1][0];
                    }
                }
            }
            return dp[0][len - 1][0] > dp[0][len - 1][1];
        }
    }

    // 看别人的简化的
    class Solution2 {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = piles[i];
            }
            for (int j = 1; j < n; j++) {
                for (int i = 0; i < j; i++) {
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }
            return dp[0][n - 1] > 0;
        }
    }
}
