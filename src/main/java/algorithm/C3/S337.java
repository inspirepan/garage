package algorithm.C3;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class S337 {
    // 用一个Map记忆一下结果，减少递归强度
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        return Math.max(helper(root, true), helper(root, false));
    }

    private int helper(TreeNode node, boolean fatherSelected) {
        if (node == null) return 0;
        if (fatherSelected) {
            return helper(node.left, false) + helper(node.right, false);
        } else {
            if (map.containsKey(node)) return map.get(node);
            else {
                int result = Math.max(
                        helper(node.left, true) + helper(node.right, true) + node.val,
                        helper(node.left, false) + helper(node.right, false)
                );
                map.put(node, result);
                return result;
            }
        }
    }

    // DFS的时候返回两个结果就好了
    public int rob2(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        int select = l[1] + r[1] + node.val;
        int notSelect = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);

        return new int[]{select, notSelect};
    }
}
