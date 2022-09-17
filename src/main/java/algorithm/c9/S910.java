package algorithm.c9;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S910 {
    class Solution {
        public int smallestRangeII(int[] nums, int k) {
            Arrays.sort(nums);
            // 贪心
            // 小的加k
            // 大的减k
            // 看中间转折点
            int n = nums.length;
            int res = nums[n - 1] - nums[0];
            for (int i = 1; i < n; i++) {
                int min = Math.min(nums[0] + k, nums[i] - k);
                int max = Math.max(nums[n - 1] - k, nums[i - 1] + k);
                res = Math.min(max - min, res);
            }
            return res;
        }
    }
}
