package algorithm.C2;

import datastructure.TreeNode;

public class S298 {
    int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }

    int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int l = helper(node.left);
        int r = helper(node.right);
        int res = 1;
        if (node.left != null && node.val == node.left.val - 1) {
            res = l + 1;
        }
        if (node.right != null && node.val == node.right.val - 1) {
            res = Math.max(res, r + 1);
        }
        max = Math.max(res, max);
        return res;
    }
}
