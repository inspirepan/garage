package algorithm.c1;

import datastructure.TreeNode;

public class S112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumWithInitialValue(root, sum, 0);
    }

    private boolean hasPathSumWithInitialValue(TreeNode root, int sum, int initialValue) {
        if (root == null) {
            return false;
        }
        int currentSum = initialValue + root.val;
        if (root.left == null && root.right == null) {
            return currentSum == sum;
        } else if (root.left == null) {
            return hasPathSumWithInitialValue(root.right, sum, currentSum);
        } else if (root.right == null) {
            return hasPathSumWithInitialValue(root.left, sum, currentSum);
        }

        return hasPathSumWithInitialValue(root.left, sum, currentSum)
                || hasPathSumWithInitialValue(root.right, sum, currentSum);
    }
}