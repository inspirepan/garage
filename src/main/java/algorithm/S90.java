package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S90 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            var path = new ArrayList<Integer>();
            dfs(nums, 0, i, path);
        }
        return result;
    }

    private void dfs(int[] nums, int s, int len, List<Integer> path) {
        if (s == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = s; i < nums.length; i++) {
            if (i > s && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1, len, path);
            path.remove(path.size() - 1);
        }
    }
}
