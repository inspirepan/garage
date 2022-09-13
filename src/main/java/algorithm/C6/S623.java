package algorithm.C6;

import datastructure.TreeNode;

public class S623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        helper(root, val, depth, 1);
        return root;
    }

    private void helper(TreeNode node, int val, int depth, int curr) {
        if (node == null) {
            return;
        }
        if (curr == depth - 1) {
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            newLeft.left = node.left;
            newRight.right = node.right;
            node.left = newLeft;
            node.right = newRight;
            return;
        }
        helper(node.left, val, depth, curr + 1);
        helper(node.right, val, depth, curr + 1);
    }
}
