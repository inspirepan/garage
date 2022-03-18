package algorithm.C6;

import datastructure.TreeNode;

public class S606 {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return String.valueOf(root.val);
        var sb = new StringBuilder();
        sb.append(root.val);
        // 左子树为空也要一个括号
        sb.append("(").append(tree2str(root.left)).append(")");
        if (root.right != null) sb.append("(").append(tree2str(root.right)).append(")");
        return sb.toString();
    }
}
