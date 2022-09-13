package algorithm.C1;

/**
 * @author panjx
 */
public class S174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        if (dungeon[m - 1][n - 1] < 0) {
            dp[m - 1][n - 1] = -dungeon[m - 1][n - 1] + 1;
        } else {
            dp[m - 1][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            int curr = dungeon[i][n - 1];
            if (curr < 0) {
                dp[i][n - 1] = dp[i + 1][n - 1] - curr;
            } else {
                dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - curr);
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            int curr = dungeon[m - 1][j];
            if (curr < 0) {
                dp[m - 1][j] = dp[m - 1][j + 1] - curr;
            } else {
                dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - curr);
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int curr = dungeon[i][j];
                if (curr < 0) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - curr;
                } else {
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - curr);
                }
            }
        }
        return dp[0][0];
    }
}