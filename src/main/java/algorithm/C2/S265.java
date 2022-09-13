package algorithm.C2;

public class S265 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            int[] currCost = costs[i];

            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int s = 0; s < k; s++) {
                    if (s == j) {
                        continue;
                    }
                    min = Math.min(min, dp[i - 1][s]);
                }
                dp[i][j] = currCost[j] + min;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}
