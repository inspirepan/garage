package algorithm.C7;

import datastructure.TreeNode;

public class S701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.left == null && root.right == null) {
            if (root.val < val) root.right = new TreeNode(val);
            else root.left = new TreeNode(val);
            return root;
        }

        if (root.left == null && root.val > val) {
            root.left = new TreeNode(val);
        } else if (root.right == null && root.val < val) {
            root.right = new TreeNode(val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}