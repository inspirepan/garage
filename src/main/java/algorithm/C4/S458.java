package algorithm.C4;

public class S458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 最多测试times次
        // 测试出若干桶、测试次数 —— 最小猪数量
        // 直接这样子dp想不明白

        // 看了题解，转换思路，i：拥有i只猪，j：最多测j轮，dp可以测出来的最大桶数
        if (buckets == 1) {
            return 0;
        }
        // 看不懂！
        int[][] dp = new int[buckets + 1][buckets + 1];
        dp[0][0] = 1;
        int times = minutesToTest / minutesToDie;
        int[][] f = new int[buckets][times + 1];
        for (int i = 0; i < buckets; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j <= times; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < buckets; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;

            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
            for (int j = 1; j <= times; j++) {
                for (int k = 0; k <= i; k++) {
                    f[i][j] += f[k][j - 1] * dp[i][i - k];
                }
            }
            if (f[i][times] >= buckets) {
                return i;
            }
        }
        return 0;
    }
}