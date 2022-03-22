package algorithm.C7;

public class S713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int t = 1;
        int count = 0;
        while (right < nums.length) {
            t *= nums[right];
            while (left <= right && t >= k) {
                t /= nums[left++];
            }
            if (t < k) {
                count += right - left + 1;
            } else {
                t = 1;
            }
            right++;
        }
        return count;
    }
}
