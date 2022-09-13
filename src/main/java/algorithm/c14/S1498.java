package algorithm.c14;

import java.util.Arrays;

public class S1498 {
    public int numSubseq(int[] nums, int target) {
        // 没思路
        // 看得答案
        // 实际上，排序后，对于固定的左右两个绝对值，满足条件的子序列等于2^len,len是窗口长度-1，每个元素都有在与不在两个状态
        Arrays.sort(nums);
        int n = nums.length;
        int mod = 1000000007;
        int[] tmp = new int[n];
        tmp[0] = 1;
        for (int i = 1; i < n; i++) {
            tmp[i] = (tmp[i - 1] << 1) % mod;
        }
        int res = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + tmp[r - l]) % mod;
                l++;
            }
        }
        return res;
    }
}
