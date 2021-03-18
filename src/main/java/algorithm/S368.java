package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        Arrays.sort(nums);

        ArrayList[] dp = new ArrayList[n];
        dp[0] = new ArrayList();
        dp[0].add(nums[0]);
        List<Integer> ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = new ArrayList();
            dp[i].add(nums[i]);

            for (int k = 0; k < i; k++) {
                if (nums[i] % nums[k] == 0) {
                    if (dp[i].size() < dp[k].size() + 1) {
                        dp[i] = new ArrayList(dp[k]);
                        dp[i].add(nums[i]);
                    }
                }
            }
            if (ans.size() < dp[i].size()) ans = dp[i];
        }
        return ans;
    }
}
