package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class S46 {

    /**
     * 维护一个boolean访问数组
     */
    List<List<Integer>> result;
    List<Integer> path;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
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
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    /**
     * 题解中看到的交换位置做法
     *
     * @param nums 数组
     * @return 全排列
     */
    public List<List<Integer>> permute2(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int start) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            // 一定注意这里是加start
            path.add(nums[start]);
            dfs(nums, start + 1);
            path.remove(path.size() - 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * BFS 队列做法
     */
    public List<List<Integer>> permute3(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 0) {
            return ans;
        }
        ans.add(Collections.singletonList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            while (ans.peek() != null && ans.peek().size() == i) {
                List<Integer> old = ans.pollFirst();
                for (int pos = 0; pos < i + 1; pos++) {
                    List<Integer> list = new ArrayList<>(old);
                    list.add(pos, nums[i]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
