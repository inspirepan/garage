package algorithm.C8;

public class S808 {

    class Solution {
        // dp思路
        public double soupServings(int N) {
            if (N >= 4800) {
                return 1.0;
            }
            int n = (int) Math.ceil(N / 25.0);
            double[][] dp = new double[n + 1][n + 1];
            // 起始条件，当ab都不够的时候，必然符合条件
            dp[0][0] = 0.5;
            for (int i = 1; i < n + 1; i++) {
                dp[i][0] = 0;
                dp[0][i] = 1;
            }
            for (int i = 1; i < n + 1; i++) {
                int a1 = Math.max(i - 4, 0);
                int a2 = Math.max(i - 3, 0);
                int a3 = Math.max(i - 2, 0);
                int a4 = Math.max(i - 1, 0);
                for (int j = 1; j < n + 1; j++) {
                    int b1 = j;
                    int b2 = Math.max(j - 1, 0);
                    int b3 = Math.max(j - 2, 0);
                    int b4 = Math.max(j - 3, 0);
                    dp[i][j] = 0.25 * (dp[a1][b1] + dp[a2][b2] + dp[a3][b3] + dp[a4][b4]);
                }
            }
            return dp[n][n];
        }
    }

    class Solution1 {
        // 超时的递归，一般超时的递归都可以改成DP写
        public double soupServings(int n) {
            return helper(n, n, 1);
        }

        double helper(int a, int b, double prob) {
            if (a <= 0 && b <= 0) {
                return prob / 2;
            }
            if (a <= 0) {
                return prob;
            }
            if (b <= 0) {
                return 0;
            }
            return helper(a - 100, b, prob / 4) + helper(a - 75, b - 25, prob / 4) +
                    helper(a - 50, b - 50, prob / 4) + helper(a - 25, b - 75, prob / 4);
        }
    }
}
