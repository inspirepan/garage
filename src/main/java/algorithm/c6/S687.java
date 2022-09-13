package algorithm.c6;

import datastructure.TreeNode;

public class S687 {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return Math.max(0, max - 1);
    }

    private int helper(TreeNode node) {
        // 返回node往下探的最长相同节点链长度

        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            int r = helper(node.right);
            if (node.val == node.right.val) {
                max = Math.max(r + 1, max);
                return r + 1;
            } else {
                return 1;
            }
        }
        if (node.right == null) {
            int l = helper(node.left);
            if (node.val == node.left.val) {
                max = Math.max(max, l + 1);
                return l + 1;
            } else {
                return 1;
            }
        }
        int l = helper(node.left);
        int r = helper(node.right);
        int t = 1;
        if (node.val == node.right.val) {
            t = r + 1;
        }
        if (node.val == node.left.val) {
            t = Math.max(t, l + 1);
        }
        if (node.val == node.left.val && node.val == node.right.val) {
            max = Math.max(max, l + r + 1);
        }
        max = Math.max(t, max);
        return t;
    }
}
