package algorithm.C15;

import java.util.Arrays;

public class S1509 {
    public int minDifference(int[] nums) {
        if (nums.length <= 3) {
            return 0;
        }
        // 移除三个最大最小值之后的极差
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        // 0 1 5 10 14
        for (int i = 0; i <= 3; i++) {
            if (3 - i < nums.length - 1) {
                min = Math.min(min, nums[nums.length - 1 - i] - nums[3 - i]);
            }
        }
        return min;
    }
}
