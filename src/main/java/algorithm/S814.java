package algorithm;

import datastructure.TreeNode;

public class S814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (root.val == 0) return null;
            else return root;
        }

        TreeNode l = pruneTree(root.left);
        TreeNode r = pruneTree(root.right);
        if (l == null && r == null) {
            if (root.val == 0) return null;
        }
        root.left = l;
        root.right = r;
        return root;
    }
}
