package algorithm.c5;

import datastructure.TreeNode;

public class S572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == subRoot) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (equalTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean equalTree(TreeNode node1, TreeNode node2) {
        if (node1 == node2) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return equalTree(node1.left, node2.left) && equalTree(node1.right, node2.right);
    }
}
