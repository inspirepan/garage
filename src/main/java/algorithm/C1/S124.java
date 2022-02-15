package algorithm.C1;

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
        // 路径只有两种情况，root结点+左右子结点的最大单链，或者左右子树中的局部最大路径（不包括root）
        // 局部最大路径
        this.max = Math.max(max, root.val + left + right);
        // 最大单链给上层用来计算
        return Math.max(left, right) + root.val;
    }
}