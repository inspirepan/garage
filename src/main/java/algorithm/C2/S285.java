package algorithm.C2;

import datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class S285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        boolean flag = false;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (flag) {
                return node;
            }
            if (node == p) {
                flag = true;
            }
            node = node.right;
        }
        return null;
    }
}
