package algorithm;

import datastructure.TreeNode;

public class S222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = this.countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    /* 计算层级 */
    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
