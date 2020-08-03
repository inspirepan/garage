package algorithm;

import datastructure.TreeNode;

public class S124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return this.max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        /* 记录局部最大值 */
        this.max = Math.max(max, root.val + left + right);
        /* 返回单边最大值 */
        return Math.max(left, right) + root.val;
    }
}