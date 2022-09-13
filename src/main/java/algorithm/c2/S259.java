package algorithm.c2;

import java.util.Arrays;

public class S259 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            ans += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return ans;
    }

    int twoSumSmaller(int[] nums, int start, int target) {
        int count = 0;
        int left = start, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                // 每一个left最大能匹配的right
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}