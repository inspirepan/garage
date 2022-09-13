package algorithm.c6;

import datastructure.TreeNode;

public class S671 {
    private static final long NOT_FOUND = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        long t;
        return (t = helper(root)) == NOT_FOUND ? -1 : (int) t;
    }

    private long helper(TreeNode node) {
        if (node == null) {
            return NOT_FOUND;
        }
        if (node.left == null) {
            return NOT_FOUND;
        }
        if (node.left.val == node.right.val) {
            return Math.min(helper(node.left), helper(node.right));
        }
        int greaterVal;
        TreeNode less;
        if (node.left.val > node.right.val) {
            greaterVal = node.left.val;
            less = node.right;
        } else {
            greaterVal = node.right.val;
            less = node.left;
        }
        return Math.min(greaterVal, helper(less));
    }
}
