package algorithm.C4;

import datastructure.Node;

public class S426 {
    public Node treeToDoublyList(Node root) {
        // 需要用一个helper，只有最顶层的root才能把末尾接到头部上
        // 先把二叉搜索树展开成一个链表
        if (root == null) {
            return null;
        }
        Node left = helper(root);
        Node p = left;
        while (p.right != null) {
            p = p.right;
        }
        p.right = left;
        left.left = p;
        return left;
    }

    private Node helper(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null) {
            // root是最小的元素
            root.right = helper(root.right);
            root.right.left = root;
            return root;
        } else if (root.right == null) {
            // root是最大的元素
            Node left = helper(root.left);
            Node p = left;
            while (p.right != null) {
                p = p.right;
            }
            p.right = root;
            root.left = p;
            return left;
        }
        // 连接左右节点
        Node left = helper(root.left);
        Node right = helper(root.right);
        Node p = left;
        while (p.right != null) {
            p = p.right;
        }
        root.left = p;
        p.right = root;
        root.right = right;
        right.left = root;
        return left;
    }
}
