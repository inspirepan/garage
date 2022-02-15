package algorithm.C1;

/**
 * @author panjx
 */
public class S174 {
    public int calculateMinimumHp(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        // 最后一间
        dp[row - 1][col - 1] = dungeon[row - 1][col - 1] > 0 ? 1 : 1 - dungeon[row - 1][col - 1];
        for (int i = row - 2; i >= 0; i--) {
            // 最低也需要生命值为1
            dp[i][col - 1] = Math.max(dp[i + 1][col - 1] - dungeon[i][col - 1], 1);
        }
        for (int j = col - 2; j >= 0; j--) {
            dp[row - 1][j] = Math.max(dp[row - 1][j + 1] - dungeon[row - 1][j], 1);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                // 计算最低需求用min，但是也不能低于1
                dp[i][j] = Math.max(-dungeon[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]), 1);
            }
        }
        return dp[0][0];
    }
}
