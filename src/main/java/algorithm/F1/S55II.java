package algorithm.F1;

import datastructure.TreeNode;

public class S55II {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root) >= 0;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        if (leftHeight < 0 || rightHeight < 0) return -1;
        if (Math.abs(leftHeight - rightHeight) <= 1) return Math.max(leftHeight, rightHeight) + 1;
        return -1;
    }
}
