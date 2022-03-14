package algorithm.C5;

import datastructure.TreeNode;

public class S549 {

    private int max;

    public int longestConsecutive(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            max = Math.max(max, findIncre(root.right, root.val) - findDecre(root.left, root.val) + 1);
            max = Math.max(max, findIncre(root.left, root.val) - findDecre(root.right, root.val) + 1);
            dfs(root.left);
            dfs(root.right);
        }
    }

    private int findDecre(TreeNode root, int parent) {
        // 返回的是往下的连续递减序列中最小值
        if (root == null || root.val != parent - 1) return parent;
        return Math.min(findDecre(root.left, root.val), findDecre(root.right, root.val));
    }

    private int findIncre(TreeNode root, int parent) {
        // 返回的是往下的连续递增序列的最大值
        if (root == null || root.val != parent + 1) return parent;
        return Math.max(findIncre(root.left, root.val), findIncre(root.right, root.val));
    }
}
