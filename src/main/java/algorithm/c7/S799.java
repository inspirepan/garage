package algorithm.c7;

public class S799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // 有点意思哦
        // 第0层1个杯子
        // 第99层100个杯子

        double[][] dp = new double[100][100];
        dp[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            // 每层
            for (int j = 0; j <= i; j++) {
                // 每列
                // 左右两个对应杯子溢出来的一半
                dp[i][j] = 0.5 * (j - 1 >= 0 ? Math.max(0, dp[i - 1][j - 1] - 1) : 0) + 0.5 * Math.max(0, dp[i - 1][j] - 1);
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}
