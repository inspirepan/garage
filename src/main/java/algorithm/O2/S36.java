package algorithm.O2;

import datastructure.Node;

public class S36 {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        // 摊平
        Node[] nodes = helper(root);
        // 连接首尾
        Node head = nodes[0];
        Node tail = nodes[1];
        head.left = tail;
        tail.right = head;
        return head;
    }

    private Node[] helper(Node root) {
        // 返回head和tail
        Node[] result = new Node[2];
        // assert root!=null
        if (root.left == null && root.right == null) {
            result[0] = result[1] = root;
            return result;
        }
        if (root.left == null) {
            Node[] nodes = helper(root.right);
            root.right = nodes[0];
            nodes[0].left = root;
            result[0] = root;
            result[1] = nodes[1];
            return result;
        }
        if (root.right == null) {
            Node[] nodes = helper(root.left);
            root.left = nodes[1];
            nodes[1].right = root;
            result[0] = nodes[0];
            result[1] = root;
            return result;
        }
        Node[] nodesLeft = helper(root.left);
        Node[] nodesRight = helper(root.right);
        result[0] = nodesLeft[0];
        result[1] = nodesRight[1];
        nodesLeft[1].right = root;
        root.left = nodesLeft[1];
        root.right = nodesRight[0];
        nodesRight[0].left = root;
        return result;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
