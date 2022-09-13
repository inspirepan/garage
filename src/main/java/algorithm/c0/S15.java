package algorithm.c0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S15 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return res;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            find(nums, i + 1, -nums[i]);
        }
        return res;
    }

    void find(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum + rightNum;
            if (sum == target) {
                res.add(Arrays.asList(-target, leftNum, rightNum));
                // 已经确定了一组的情况下，去重
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}

