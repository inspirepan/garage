package algorithm.C1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import datastructure.TreeNode;

public class S145 {
    /* 迭代 */

    public List<Integer> postorderTraversal2(TreeNode root) {
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || visited.contains(node.right)) {
                result.add(node.val);
                visited.add(node);
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return result;
    }
}