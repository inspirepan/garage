package algorithm.S101to200;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import datastructure.TreeNode;

public class S144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> result = new LinkedList<>(Collections.singleton(root.val));
        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }

        }
        return result;
    }

    /* 遍历的方法，注意一定是先进栈再移动到子结点 */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }
}