package algorithm;

import java.util.LinkedList;
import java.util.List;

public class S491 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return result;
    }

    private void dfs(int start, int last, int[] nums) {
        if (start == nums.length) {
            if (path.size() > 1) {
                result.add(new LinkedList<>(path));
            }
            return;
        }
        if (nums[start] >= last) {
            path.add(nums[start]);
            dfs(start + 1, nums[start], nums);
            path.removeLast();
        }
        if (nums[start] != last) {
            dfs(start + 1, last, nums);
        }
    }

}
