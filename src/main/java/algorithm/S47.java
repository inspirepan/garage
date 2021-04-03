package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S47 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        path = new ArrayList<>();
        visited = new boolean[nums.length];
        dfs(nums);
        return result;
    }

    private void dfs(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // 加一个剪枝，如果与上一个相同，并且上一个没有访问过，就跳过这个（只有两个都用上才加进去）。
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}