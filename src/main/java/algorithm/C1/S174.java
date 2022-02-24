package algorithm.C1;

/**
 * @author panjx
 */
public class S174 {
    public int calculateMinimumHp(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        // 最后一间
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        // 最后一列
        for (int i = m - 2; i >= 0; i--) {
            // 最低也需要生命值为1
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        // 最后一行
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // 计算最低需求用min，但是也不能低于1
                dp[i][j] = Math.max(-dungeon[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]), 1);
            }
        }
        return dp[0][0];
    }
}
