package algorithm.C5;

import java.util.Arrays;

public class S583 {
    public int minDistance(String word1, String word2) {
        // 求两个字符串中的最长公共子序列
        // dp[i][j]表示字符串前ij个字符中公共子序列最长长度？
        // dp好不熟练，可以想出来递推关系，但是不知道怎么初始化

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return m + n - dp[m][n] * 2;
    }
}
