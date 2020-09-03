package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求和系列
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSumClosest(new int[]{-1, 1, 2, -4}, 1));
    }

    /**
     * 15
     * 三数之和
     * 转换成两数之和问题
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复项
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            // 用双指针逼近求两数之和
            while (left < right) {
                // 跳过重复项
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                // 跳过重复项
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    // 不能直接break
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复项
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            // 用双指针逼近求两数之和
            while (left < right) {
                // 跳过重复项
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                // 跳过重复项
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                int dist;
                if (min > (dist = Math.abs(sum - target))) {
                    ans = sum;
                    min = dist;
                }
            }
        }
        return ans;
    }
}
