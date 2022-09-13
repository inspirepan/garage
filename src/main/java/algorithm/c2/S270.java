package algorithm.c2;

import datastructure.TreeNode;

public class S270 {
    int ans = 0;
    int prev;
    boolean found = false;

    public int closestValue(TreeNode root, double target) {
        prev = Integer.MIN_VALUE + root.val + (int) target;
        inorder(root, target);
        if (found) {
            return ans;
        } else {
            return prev;
        }
    }

    void inorder(TreeNode node, double target) {
        if (found) {
            return;
        }
        if (node.left != null) {
            inorder(node.left, target);
        }
        if (node.val >= target && prev < target) {
            found = true;
            if (node.val - target > target - prev) {
                ans = prev;
            } else {
                ans = node.val;
            }
        }
        prev = node.val;

        if (node.right != null) {
            inorder(node.right, target);
        }
    }
}
