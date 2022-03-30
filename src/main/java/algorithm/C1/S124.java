package algorithm.C1;

import datastructure.TreeNode;

public class S124 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        // 返回往下的最大路径和
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            max = Math.max(max, node.val);
            return node.val;
        }

        int l = helper(node.left);
        int r = helper(node.right);
        int result = Math.max(l, r);
        result = Math.max(result + node.val, node.val);
        max = Math.max(max, result);
        max = Math.max(max, l + r + node.val);
        return result;
    }
}