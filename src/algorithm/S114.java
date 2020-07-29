package algorithm;

import dataStructure.TreeNode;

public class S114 {
    /* 二叉树展开为链表 */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        else if (root.left == null)
            flatten(root.left);
        else if (root.right == null) {
            root.right = root.left;
            root.left = null;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left =null;
        while (root.right != null)
            root = root.right;
        root.right = temp;
    }
}