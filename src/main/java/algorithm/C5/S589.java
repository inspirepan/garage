package algorithm.C5;

import datastructure.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S589 {
    public List<Integer> preorder(Node root) {
        // 递归
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        for (Node child : node.children) helper(child, result);
    }

    public List<Integer> preorder2(Node root) {
        // 迭代
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            // 倒序
            for (int i = node.children.size() - 1; i >= 0; i--) stack.add(node.children.get(i));
        }
        return result;
    }
}
