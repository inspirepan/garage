package algorithm.c0;

import datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 */
public class S94 {
    private final List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        } else {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result2 = new ArrayList<>();
        var stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result2.add(root.val);
                root = root.right;
            }
        }
        return result2;
    }
}
