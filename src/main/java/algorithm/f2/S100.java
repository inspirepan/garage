package algorithm.f2;

import java.util.List;

public class S100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height][height];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < height; i++) {
            var curr = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + curr.get(0);
            dp[i][i] = dp[i - 1][i - 1] + curr.get(i);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + curr.get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < height; j++) {
            min = Math.min(min, dp[height - 1][j]);
        }
        return min;
    }
}
