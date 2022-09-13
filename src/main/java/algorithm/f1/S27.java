package algorithm.f1;

import datastructure.TreeNode;

public class S27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode l = mirrorTree(root.right);
        TreeNode r = mirrorTree(root.left);
        root.left = l;
        root.right = r;
        return root;
    }
}
