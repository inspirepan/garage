package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

import datastructure.TreeNode;

public class S98 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (!isValidBST(root.left))
                return false;
            if (root.val <= pre)
                return false;
            pre = root.val;
            return isValidBST(root.right);
        }
    }

    /* 迭代 */
    public boolean isValidBST2(TreeNode root) {
        long prev = Long.MIN_VALUE;
        TreeNode node = root;
        Deque<TreeNode> queue = new ArrayDeque<>();
        while (node != null || !queue.isEmpty()) {
            while (node != null) {
                queue.push(node);
                node = node.left;
            }
            node = queue.pop();
            if (node.val <= prev) {
                return false;
            }
            prev = node.val;
            node = node.right;
        }
        return true;
    }
}
