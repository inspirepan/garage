package algorithm;

import dataStructure.TreeNode;

public class S104 {
    /* 二叉树最大深度 */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        else
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}