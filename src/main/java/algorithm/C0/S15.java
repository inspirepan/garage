package algorithm.C0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S15 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            find(nums, -nums[i], i + 1);
        }
        return result;
    }

    private void find(int[] nums, int target, int start) {
        int l = start, r = nums.length - 1;
        while (l < r) {
            int t = nums[l] + nums[r];
            if (t == target) {
                result.add(List.of(-target, nums[l], nums[r]));
                l++;
                while (l < r && nums[l] == nums[l - 1]) l++;
                r--;
                while (r > l && nums[r] == nums[r + 1]) r--;
            } else if (t > target) {
                r--;
                while (r > l && nums[r] == nums[r + 1]) r--;
            } else {
                l++;
                while (l < r && nums[l] == nums[l - 1]) l++;
            }
        }
    }
}

