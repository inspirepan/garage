package algorithm.c10;

/**
 * @author : panjixiang
 * @since : 2022/11/16
 */
public class S1004 {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0;
            int right = 0;
            int max = 0;
            int curr = 0;
            int len = nums.length;
            while (right < len) {
                if (nums[right++] == 0) {
                    curr++;
                }
                while (left < right && curr > k) {
                    if (nums[left] == 0) {
                        curr--;
                    }
                    left++;
                }
                max = Math.max(right - left, max);
            }
            return max;
        }
    }
}
