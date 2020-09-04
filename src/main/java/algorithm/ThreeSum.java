package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求和系列
 * 使用双指针求两数之和
 * 更多的数只能用循环遍历了
 * 需要注意的是 1.排序后去重；2.剪枝掉大于1/4，1/3后面的部分
 *
 * @author panjx
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

    /**
     * 16 最接近的三数之和
     */
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

    /**
     * 18 四数之和
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len;
        // 剪枝
        if ((len = nums.length) < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 到最大了
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 最大也不够大，继续加i
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 还不够大，不用搜索两数之和，继续加j
                if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int currTarget = target - nums[i] - nums[j], left = j + 1, right = len - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[left + 1] > target) {
                        break;
                    }
                    int sum = nums[left] + nums[right];
                    if (sum == currTarget) {
                        // Arrays.asList 居然比 List.of 快
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        // 跳过重复项可以放在等于之后再执行！
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < currTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
