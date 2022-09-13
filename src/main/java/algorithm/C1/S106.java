package algorithm.C1;

import datastructure.TreeNode;

public class S106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return helper(inorder, postorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder,
                            int inLeft, int inRight, int postLeft, int postRight) {

        if (inRight == inLeft) {
            return new TreeNode(inorder[inLeft]);
        }
        if (inLeft > inRight || postRight < 0 || inRight < 0 || inLeft >= inorder.length || postLeft >= postorder.length) {
            return null;
        }
        int rootVal = postorder[postRight];
        int rootIndex = inLeft;
        while (rootIndex <= inRight && inorder[rootIndex] != rootVal) {
            rootIndex++;
        }
        TreeNode root = new TreeNode(rootVal);
        int leftTreeLength = rootIndex - inLeft;
        int rightTreeLength = inRight - rootIndex;
        root.left = helper(inorder, postorder, inLeft, inLeft + leftTreeLength - 1, postLeft,
            postLeft + leftTreeLength - 1);
        root.right = helper(inorder, postorder, inRight - rightTreeLength + 1, inRight, postRight - rightTreeLength, postRight - 1);
        return root;
    }
}
