package algorithm.C0;

public class S10 {
    class Solution {
        public boolean isMatch(String s, String p) {
            char[] arr1 = s.toCharArray();
            char[] arr2 = p.toCharArray();
            int m = arr1.length;
            int n = arr2.length;
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr2[j - 1] == '*') {
                        // 可以匹配若干个j-2处的字符
                        // 0个
                        dp[i][j] = dp[i][j - 2];
                        if (match(arr1, arr2, i - 1, j - 2)) {
                            if (dp[i - 1][j]) {
                                dp[i][j] = true;
                            }
                        }
                    } else {
                        if (match(arr1, arr2, i - 1, j - 1)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }

            return dp[m][n];
        }

        boolean match(char[] arr1, char[] arr2, int a, int b) {
            if (a < 0) {
                return false;
            }
            if (arr2[b] == '.') {
                return true;
            }
            return arr1[a] == arr2[b];
        }
    }
}
