package algorithm;

/**
 * @author panjx
 */
public class S1140 {

    /**
     * 动态规划玩不明白
     *
     * 每堆都有正整数颗石子piles[i]。游戏以谁手中的石子最多来决出胜负。
     * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
     * 在每个玩家的回合中，该玩家可以拿走剩下的前X堆的所有石子，其中1 <= X <= 2M。然后，令M = max(M, X)。
     * 游戏一直持续到所有石子都被拿走。
     * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
     */
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int sum = 0;
        // 在i之前的石碓都被取走、M=j的情况下，先取能够拿到的最大值
        int[][] dp = new int[len][len + 1];
        // 倒着来
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = len; m >= 1; m--) {
                int limit = 2 * m;
                // 如果已经可以拿走全部石碓
                if (i + limit >= len) {
                    dp[i][m] = sum;
                } else {
                    // 否则，找出最佳拿法
                    for (int x = 1; x <= limit; x++) {
                        dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
