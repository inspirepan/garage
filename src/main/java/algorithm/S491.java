package algorithm;

import java.util.LinkedList;
import java.util.List;

public class S491 {

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        // 题目要求的不是连续子序列，是子序列！！
        dfs(0, Integer.MIN_VALUE, nums);
        return result;
    }

    private void dfs(int start, int last, int[] nums) {
        // 到终点了
        if (start == nums.length) {
            if (path.size() > 1) {
                result.add(new LinkedList<>(path));
            }
            return;
        }
        // 如果递增
        if (nums[start] >= last) {
            path.add(nums[start]);
            dfs(start + 1, nums[start], nums);
            path.removeLast();
        }
        // 如果一样，剪枝；path中不加入当前节点
        if (nums[start] != last) {
            dfs(start + 1, last, nums);
        }
    }
}
