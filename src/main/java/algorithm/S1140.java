package algorithm;

/**
 * @author panjx
 */
public class S1140 {

    /**
     * 动态规划玩不明白
     */

    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int sum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = len; m >= 1; m--) {
                int limit = 2 * m;
                if (i + limit >= len) {
                    dp[i][m] = sum;
                } else {
                    for (int x = 1; x <= limit; x++) {
                        dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
