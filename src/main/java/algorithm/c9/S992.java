package algorithm.c9;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/11/11
 */
public class S992 {
    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            // 写这题有点嫌麻烦的心态了，不可以
            int len = nums.length;
            int left = 0;
            int right = 0;
            int count = 0;
            int res = 0;
            int[] lastOccur = new int[len + 1];
            Arrays.fill(lastOccur, -1);
            while (left <= right && right < len) {
                if (lastOccur[nums[right]] == -1) {
                    ++count;
                }
                lastOccur[nums[right]] = right;
                while (count > k) {
                    while (left < right && left < lastOccur[nums[left]]) {
                        ++left;
                    }
                    lastOccur[nums[left]] = -1;
                    ++left;
                    count--;
                }
                if (count == k) {
                    res++;
                    for (int i = left; i < lastOccur[nums[i]] && i < right; ++i) {
                        res++;
                    }
                }
                ++right;
            }
            return res;
        }
    }
}
