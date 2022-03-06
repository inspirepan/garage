package algorithm.C4;

import datastructure.TreeNode;

public class S450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } // 删除当前节点
        else if (root.val == key) {
            // 叶子节点直接删除
            if (root.left == null && root.right == null) {
                root = null;
            // 如果只有右子树
            } else if (root.left == null) {
                root = root.right;
            // 如果只有左子树
            } else if (root.right == null) {
                root = root.left;
            } else {
                // 需要重新结合左右子节点
                TreeNode temp = getMinChild(root.right);
                temp.right = deleteMin(root.right);
                temp.left = root.left;
                return temp;
            }
        } // 递归搜索
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            root.right = deleteNode(root.right, key);
            return root;
        }
        return root;
    }

    private TreeNode deleteMin(TreeNode node) {
        // 最重要的一个函数，找到第一个没有左孩子的节点，就是最小值，把他删掉，返回它的右孩子
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    private TreeNode getMinChild(TreeNode node) {
        // 注意是BST，只要找左孩子
        if (node.left == null) {
            return node;
        }
        return getMinChild(node.left);
    }
}