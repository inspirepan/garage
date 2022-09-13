package algorithm.C4;

import datastructure.TreeNode;

public class S404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int parent) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (parent == 1) {
                return root.val;
            } else {
                return 0;
            }
        }
        return sum(root.left, 1) + sum(root.right, 0);
    }
}
