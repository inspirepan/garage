package algorithm.C4;

import datastructure.TreeNode;

import java.util.*;

public class S437 {
    // sum, count;
    Map<Integer, Integer> map = new HashMap<>();
    int targetSum;
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和
        map.put(0, 1);
        this.targetSum = targetSum;
        dfs(root, 0);
        return count;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) return;

        sum += node.val;
        if (map.containsKey(sum - targetSum)) {
            count += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        dfs(node.left, sum);
        dfs(node.right, sum);

        int c = map.get(sum) - 1;
        if (c == 0) {
            map.remove(sum);
        } else {
            map.put(sum, c);
        }
    }
}
