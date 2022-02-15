package algorithm.C1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import datastructure.TreeNode;

public class S145 {
    /* 迭代 */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            /* 没有右孩子，或者右孩子刚刚访问过，这里是直接用val判断是否访问过的，应该用Set的 */
            if (node.right == null || (result.size() != 0 && node.right.val == result.get(result.size() - 1))) {
                result.add(node.val);
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return result;
    }

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