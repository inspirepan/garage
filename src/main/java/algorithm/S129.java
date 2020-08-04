package algorithm;

import datastructure.TreeNode;

public class S129 {
    /* 直观拼接 */
    private final StringBuilder sb = new StringBuilder();
    private int val = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root);
        return val;

    }

    public int sumNumbers2(TreeNode root) {
        return dfs2(root, 0);
    }

    /* 加法计算 */
    private int dfs2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        return dfs2(root.left, sum * 10 + root.val) + dfs2(root.right, sum * 10 + root.val);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            val += Integer.valueOf(sb.toString());
            sb.setLength(sb.length() - 1);
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        sb.setLength(sb.length() - 1);
    }

}