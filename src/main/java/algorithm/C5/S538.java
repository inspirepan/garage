package algorithm.C5;

import datastructure.TreeNode;

public class S538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        sum = getSum(root);
        inOrder(root);
        return root;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return getSum(root.left) + getSum(root.right) + root.val;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        int t = node.val;
        node.val = sum;
        sum -= t;
        inOrder(node.right);
    }
}
