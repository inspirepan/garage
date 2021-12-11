package algorithm.S101to200;

import java.util.List;

public class S120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        // i: level, j: horizon index, dp: current the least path from bottom
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        // from bottom level to top
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            // each position
            for (int j = 0; j < curr.size(); j++) {
                // choose the less path
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curr.get(j);
            }
        }
        return dp[0][0];
    }
}