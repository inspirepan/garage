package algorithm.C7;

public class S714 {
    public int maxProfit(int[] prices, int fee) {
        int a = 0;
        int b = -prices[0];
        for (int p : prices) {
            int temp = a;
            a = Math.max(a, b + p - fee);
            b = Math.max(b, temp - p);
        }
        return a;
    }
}
