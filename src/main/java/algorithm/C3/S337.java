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
}
