package algorithm.c10;

import datastructure.TreeNode;

public class S1080 {
    int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        this.limit = limit;
        if (limit > dfs(root, 0)) {
            return null;
        }
        return root;
    }

    int dfs(TreeNode node, int sum) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (node.left == null && node.right == null) {
            return node.val + sum;
        }
        sum += node.val;
        int left = dfs(node.left, sum);
        int right = dfs(node.right, sum);

        if (left < limit) {
            node.left = null;
        }
        if (right < limit) {
            node.right = null;
        }
        return Math.max(left, right);
    }
}
