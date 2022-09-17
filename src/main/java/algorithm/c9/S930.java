package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S930 {
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int res = 0;
            int n = nums.length;
            int[] sumCount = new int[n + 1];
            sumCount[0] = 1;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum - goal >= 0) {
                    res += sumCount[sum - goal];
                }
                sumCount[sum]++;
            }
            return res;
        }
    }
}
