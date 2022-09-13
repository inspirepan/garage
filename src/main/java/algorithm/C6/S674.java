package algorithm.C6;

public class S674 {
    public int findLengthOfLCIS(int[] nums) {
        // 连续的很简单
        int left = 0;
        int right = 1;
        int max = 1;
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        while (right < len) {
            while (right < len && nums[right] > nums[right - 1]) {
                right++;
            }
            max = Math.max(max, right - left);
            left = right;
            right++;
        }
        return max;
    }
}
