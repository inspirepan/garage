package algorithm.C1;

public class S122 {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            total += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return total;
    }
}