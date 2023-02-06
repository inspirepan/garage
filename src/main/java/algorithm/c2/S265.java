package algorithm.c2;

public class S265 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        System.arraycopy(costs[0], 0, dp[0], 0, k);
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
