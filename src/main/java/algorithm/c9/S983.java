package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/10/30
 */
public class S983 {
    static class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int[] dp = new int[days.length + 1];
            for (int i = 0; i < days.length; i++) {
                dp[i + 1] = costs[0] + dp[i];
                // 七天票
                int j = i - 1;
                while (j >= 0 && days[i] - days[j] < 7) {
                    j--;
                }
                // 三十天票
                int k = j;
                while (k >= 0 && days[i] - days[k] < 30) {
                    k--;
                }
                dp[i + 1] = Math.min(dp[i + 1], Math.min(dp[j + 1] + costs[1], dp[k + 1] + costs[2]));
            }
            return dp[dp.length - 1];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
    }
}
