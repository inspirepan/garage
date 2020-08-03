package algorithm;

public class S121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            if (currentPrice - minPrice > maxProfit) {
                maxProfit = currentPrice - minPrice;
            } else if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
        }
        return maxProfit;
    }
}