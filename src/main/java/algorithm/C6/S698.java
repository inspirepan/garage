package algorithm.C6;

import java.util.Arrays;

public class S698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 元素都是正整数
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum == 0) {
            return true;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        // 从大往小匹配
        int[] targets = new int[k];
        Arrays.fill(targets, target);
        return dfs(nums.length - 1, targets, nums);
    }

    private boolean dfs(int curr, int[] targets, int[] nums) {
        if (curr < 0) {
            return true;
        }
        // 将当前curr处的数加入target
        for (int i = 0; i < targets.length; i++) {
            // 剪枝！ 从1995ms变成了1ms，这个区别...
            if (i > 0 && targets[i] == targets[i - 1]) {
                continue;
            }
            if (targets[i] == nums[curr] || targets[i] >= nums[curr] + nums[0]) {
                targets[i] -= nums[curr];
                if (dfs(curr - 1, targets, nums)) {
                    return true;
                }
                targets[i] += nums[curr];
            }
        }
        return false;
    }
}
