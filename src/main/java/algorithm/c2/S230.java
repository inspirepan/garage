package algorithm.c2;

import datastructure.TreeNode;

public class S230 {
    private int k;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode node) {
        if (node != null) {
            helper(node.left);
            k--;
            if (k == 0) {
                result = node.val;
                return;
            }
            helper(node.right);
        }
    }
}
