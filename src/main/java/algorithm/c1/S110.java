package algorithm.c1;

import datastructure.TreeNode;

public class S110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        S104 height = new S104();
        return Math.abs(height.maxDepth(root.left) - height.maxDepth(root.right)) < 2 && isBalanced(root.left)
                && isBalanced(root.right);
    }
}