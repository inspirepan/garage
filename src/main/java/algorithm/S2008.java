package algorithm;

import java.util.Arrays;

public class S2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        // 没有思路，太久没有做题了
        // 应该是使用DP，如何递进呢
        // DP[n]表示终点为n时最大的利润
        // 根据终点位置排序
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        long[] dp = new long[n + 1];
        for (int i = 1, p = 0; i <= n; i++) {
            long maxi = dp[i - 1];
            // 循环到第p个终点为i的
            for (; p < rides.length && rides[p][1] == i; p++) {
                int[] ride = rides[p];
                // 乘客p的起点处的最大利润+乘客p的利润=当前方案的利润
                maxi = Math.max(maxi, ride[1] - ride[0] + ride[2] + dp[ride[0]]);
            }
            dp[i] = maxi;
        }
        return dp[n];
    }
}
