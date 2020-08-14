package algorithm;

import datastructure.TreeNode;

public class S450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode temp = getMinChild(root.right);
                temp.right = deleteMin(root.right);
                temp.left = root.left;
                return temp;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        return root;
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    private TreeNode getMinChild(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return getMinChild(node.left);
    }
}