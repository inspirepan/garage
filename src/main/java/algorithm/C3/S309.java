package algorithm.C3;

public class S309 {
    public int maxProfit(int[] prices) {

        int len = prices.length;
        int[][] dp = new int[len][3];
        // 0 未持有股票
        // 1 未持有股票 处于冷冻期
        // 2 持有股票

        dp[0][2] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 要么前一天要么是0要么是1状态
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 前一天持有股票然后今天卖掉，那么今天就是冷冻期
            dp[i][1] = dp[i - 1][2] + prices[i];
            // 要么前一天也是2状态，要么是0状态买入股票
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] - prices[i]);
        }
        // 结果只考虑未持有股票的状态
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public int maxProfit2(int[] prices) {
        int a = 0;
        int b = Integer.MIN_VALUE;
        int c = 0;
        for (int price : prices) {
            int temp = c;
            c = b + price;
            b = Math.max(b, a - price);
            a = Math.max(a, temp);
        }
        return Math.max(a, c);
    }
}
