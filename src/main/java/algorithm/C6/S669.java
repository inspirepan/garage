package algorithm.C6;

import datastructure.TreeNode;

public class S669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val == low) {
            root.left = null;
            root.right = trimBST(root.right, low, high);
            return root;
        }
        if (root.val == high) {
            root.right = null;
            root.left = trimBST(root.left, low, high);
            return root;
        }
        // low<root<right
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
