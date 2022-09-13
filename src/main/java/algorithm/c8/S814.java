package algorithm.c8;

import datastructure.TreeNode;

public class S814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                return null;
            } else {
                return root;
            }
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (left == null && right == null && root.val == 0) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
