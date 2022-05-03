package algorithm.C8;

public class S813 {
    class Solution {
        public double largestSumOfAverages(int[] A, int K) {
            //  尽可能多分组
            //  当k<nums.length的时候，考虑合并更小的

            // 哦忘记了是分成子数组不是随意分组
            double[][] dp = new double[A.length + 1][K + 1];
            // 额外记录一个sum数组保存到前i个数的和, 便于计算(A[j+1] + ... + A[i+1]) / (i-j)
            double[] sum = new double[A.length + 1];

            for (int i = 1; i <= A.length; ++i) {
                sum[i] = sum[i - 1] + A[i - 1];
                dp[i][1] = sum[i] / i;
            }
            for (int i = 1; i <= A.length; ++i) {
                for (int k = 2; k <= K; ++k) {
                    for (int j = 0; j < i; ++j) {
                        dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (sum[i] - sum[j]) / (i - j));
                    }
                }
            }

            return dp[A.length][K];
        }
    }
}
