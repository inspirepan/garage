package algorithm.C5;

import datastructure.TreeNode;

public class S543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max - 1;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            max = Math.max(1, max);
            return 1;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
