package algorithm;

import java.util.Arrays;

public class S1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] < k) {
                    res = Math.max(res, nums[i] + nums[j]);
                }
            }
        }
        return res;
    }

    public int twoSumLessThanK2(int[] nums, int k) {
        if (nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int right = nums.length - 1;
        int left = 0;
        int res = -1;
        while (left < right) {
            if (nums[left] + nums[right] >= k) {
                right--;
            } else {
                res = Math.max(res, nums[left] + nums[right]);
                left++;
            }
        }
        return res;
    }
}
