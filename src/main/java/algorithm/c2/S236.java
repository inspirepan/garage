package algorithm.c2;

import datastructure.TreeNode;

public class S236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 这好像是Git的一个算法，找到两个版本的最近分裂版本
        if (root == null || root == p || root == q) {
            return root;
        }
        if (p.left == q || p.right == q) {
            return p;
        }
        if (q.left == p || q.right == p) {
            return q;
        }
        if (root.left == null) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.right == null) {
            return lowestCommonAncestor(root.left, p, q);
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
