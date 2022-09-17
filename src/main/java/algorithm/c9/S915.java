package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S915 {
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int[] leftMax = new int[n];
            int[] rightMin = new int[n + 1];
            int currMax = nums[0];
            for (int i = 0; i < n; i++) {
                currMax = Math.max(currMax, nums[i]);
                leftMax[i] = currMax;
            }
            rightMin[n] = Integer.MAX_VALUE;
            int currMin = nums[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                currMin = Math.min(currMin, nums[i]);
                rightMin[i] = currMin;
            }

            for (int i = 0; i < n; i++) {
                if (leftMax[i] <= rightMin[i + 1]) {
                    return i + 1;
                }
            }
            return -1;
        }
    }
}
