package algorithm.C7;

import java.util.*;

public class S764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        int[][] dp = new int[n][n];

        for (int[] mine : mines)
            banned.add(mine[0] * n + mine[1]);
        int max = 0, count;

        for (int x = 0; x < n; ++x) {
            count = 0;
            for (int y = 0; y < n; ++y) {
                // 计算左边
                count = banned.contains(x * n + y) ? 0 : count + 1;
                dp[x][y] = count;
            }

            count = 0;
            for (int y = n - 1; y >= 0; --y) {
                // 右边
                count = banned.contains(x * n + y) ? 0 : count + 1;
                dp[x][y] = Math.min(dp[x][y], count);
            }
        }

        for (int y = 0; y < n; ++y) {
            count = 0;
            for (int x = 0; x < n; ++x) {
                count = banned.contains(x * n + y) ? 0 : count + 1;
                dp[x][y] = Math.min(dp[x][y], count);
            }

            count = 0;
            for (int x = n - 1; x >= 0; --x) {
                count = banned.contains(x * n + y) ? 0 : count + 1;
                dp[x][y] = Math.min(dp[x][y], count);
                max = Math.max(max, dp[x][y]);
            }
        }

        return max;
    }
}
