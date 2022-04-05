package algorithm.C1;

import datastructure.TreeNode;

public class S156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;

        return helper(root, null, null);
    }

    public TreeNode helper(TreeNode node, TreeNode parent, TreeNode right) {
        if (node.left == null) {
            node.left = right;
            node.right = parent;
            return node;
        }
        TreeNode l = node.left;
        TreeNode r = node.right;
        node.left = right;
        node.right = parent;
        return helper(l, node, r);
    }
}
