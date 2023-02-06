package algorithm.c4;

import java.util.HashMap;
import java.util.Map;

public class S446 {
    public int numberOfArithmeticSlices(int[] nums) {
        // 两个位置可以确定一个等差序列的差值，但是可以匹配多个前缀，那么dp中应该保存的是什么呢，肯定不是最长序列长度了

        // 因为公差太大了，所以用哈希代替数组

        int ans = 0;
        int n = nums.length;

        // tail i, distance -- count
        Map<Long, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long dist = (long) nums[i] - nums[j];
                int cnt = dp[j].getOrDefault(dist, 0);
                ans += cnt;
                dp[i].put(dist, dp[i].getOrDefault(dist, 0) + cnt + 1);
            }
        }
        return ans;
    }
}
