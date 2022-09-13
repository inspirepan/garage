package algorithm.c1;

public class S123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int a = 0;
        int b = -prices[0];
        int c = 0;
        int d = -prices[0];

        for (int i = 1; i < len; i++) {
            int p = prices[i];
            // 持有0，完成2笔或者初始
            a = Math.max(a, d + p);
            // 持有第一笔，必然是-p
            b = Math.max(b, -p);
            // 卖出一笔后
            c = Math.max(c, b + p);
            // 持有第二笔
            d = Math.max(d, c - p);
        }
        return a;
    }
}