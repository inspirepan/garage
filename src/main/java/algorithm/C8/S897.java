package algorithm.C8;

import datastructure.TreeNode;

public class S897 {

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left == null) {
            root.right = increasingBST(root.right);
            return root;
        }
        TreeNode left = increasingBST(root.left);
        TreeNode right = increasingBST(root.right);
        TreeNode p = left;
        while (p.right != null) {
            p = p.right;
        }
        p.right = root;
        root.right = right;

        root.left = null;
        return left;
    }
}
