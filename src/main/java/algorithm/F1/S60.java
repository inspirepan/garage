package algorithm.F1;

public class S60 {
    public double[] dicesProbability(int n) {
        // n个骰子 最小值n,最大值6*n

        // 每投一个骰子，1-6的概率都是1/6，
        int i = 1;
        double[][] dp = new double[n + 1][6 * n + 1];
        dp[0][0] = 1.0;
        // 初始1
        while (i <= n) {
            // 投第i个骰子
            // 上一个骰子的结果每个概率*1/6+点数
            double[] lastProb = dp[i - 1];
            double[] currProb = dp[i];
            for (int k = 0; k < lastProb.length; k++) {
                if (lastProb[k] > 0) {
                    for (int j = 1; j <= 6; j++) {
                        currProb[k + j] += lastProb[k] / 6;
                    }
                }
            }
            i++;
        }
        double[] res = new double[6 * n - n + 1];
        int index = 0;
        for (int k = 0; k <= 6 * n; k++) {
            if (dp[n][k] > 0) {
                res[index++] = dp[n][k];
            }
        }
        return res;
    }
}
