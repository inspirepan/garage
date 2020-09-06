package algorithm;

import java.util.*;

public class L31_42 {


    /**
     * 39
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return null;
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        dfs(candidates, candidates.length, target, 0, new ArrayDeque<>(), ans);
        return ans;
    }

    public void dfs(int[] candidates, int len, int residue, int begin, Deque<Integer> path, List<List<Integer>> ans) {
        if (residue == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (i > begin && candidates[i] == candidates[i - 1])
                continue;// 40问
            if (residue - candidates[i] < 0)
                break;
            path.add(candidates[i]);
            dfs(candidates, len, residue - candidates[i], i + 1, path, ans); // 40问
            path.removeLast();
        }
    }

    /**
     * 40
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)
            return null;
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList<>();
        dfs(candidates, candidates.length, target, 0, new ArrayDeque<>(), ans);
        return ans;
    }

    /**
     * 41
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;
        boolean a = true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
            if (a && num > 0)
                a = false;
        }
        if (a)
            return 1;
        else {
            int k = 1;
            while (map.containsKey(k)) {
                k++;
            }
            return k;
        }
    }

    /**
     * 42 韦恩图法
     */
    public int trap(int[] height) {
        if (height.length < 2)
            return 0;

        /* 从左往右 */
        int S1 = 0;
        int S2 = 0;
        int heightSum = 0;
        int max1 = 0, max2 = 0;
        for (int i = 0; i < height.length; i++) {
            max1 = Math.max(max1, height[i]);
            max2 = Math.max(max2, height[height.length - i - 1]);
            S1 += max1;
            S2 += max2;
            heightSum += height[i];
        }

        return (S1 + S2 - height.length * Math.max(max1, max2)) - heightSum;
    }
}
