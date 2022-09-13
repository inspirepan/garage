package algorithm.c4;

import java.util.Arrays;

public class S462 {
    public int minMoves2(int[] nums) {
        // 每次一个元素+1或者-1
        // 先把数组排序
        // 从数组最小元素开始，每次往上增加，那么 大于他的元素距离-1 小于它的元素距离+1
        // 直接加减可能会导致越界
        // 找数组中位数
        Arrays.sort(nums);
        int mid = 0;
        if (nums.length <= 1) {
            return 0;
        }
        if ((nums.length & 1) == 1) {
            mid = nums[nums.length / 2];
        } else {
            mid = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        }
        int result = 0;
        for (int num : nums) {
            result += Math.abs(num - mid);
        }
        return result;
    }
}
