package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class S589 {
    /**
     * 递归
     */
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        preorderHelper(root);
        return result;
    }

    private void preorderHelper(Node node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        node.children.forEach(this::preorderHelper);
    }

    /**
     * 迭代
     */
    public List<Integer> preorder2(Node root) {
        var list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        var stack = new ArrayDeque<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return list;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val_) {
            val = val_;
        }

        public Node(int val_, List<Node> children_) {
            val = val_;
            children = children_;
        }
    }

    ;
}
