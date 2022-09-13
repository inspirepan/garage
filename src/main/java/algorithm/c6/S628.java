package algorithm.c6;

import java.util.Arrays;

public class S628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[len - 1] < 0) {
            // 全负数
            return nums[len - 1] * nums[len - 2] * nums[len - 3];
        } else if (nums[len - 1] == 0) {
            return 0;
        } else {
            int temp = Integer.MIN_VALUE;
            if (nums[len - 2] > 0 && nums[len - 3] > 0) {
                temp = nums[len - 1] * nums[len - 2] * nums[len - 3];
            }
            temp = Math.max(temp, nums[len - 1] * nums[0] * nums[1]);
            return temp;
        }
    }
}
