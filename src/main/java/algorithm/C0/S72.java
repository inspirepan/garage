package algorithm.C0;

import java.util.Arrays;

public class S72 {
    /**
     * 编辑距离
     */
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int m = arr1.length;
        int n = arr2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] k : dp) {
            Arrays.fill(k, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                } else {
                    // 增删
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j], dp[i][j + 1]) + 1;
                    // 替换
                    dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, dp[i + 1][j + 1]);
                }
            }
        }
        return dp[m][n];
    }
}
