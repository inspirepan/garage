package algorithm.C7;

public class S712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + (int) s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + (int) s2.charAt(j - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // s1的i位置元素或者s2j位置上元素不属于最短子序列
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1] + (int) s1.charAt(i), dp[i + 1][j] + (int) s2.charAt(j));
                }
            }
        }
        return dp[m][n];
    }
}
