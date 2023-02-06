package algorithm.c1;

import datastructure.TreeNode;

import java.util.HashMap;

public class S105 {
    /* 从前序与中序遍历序列构造二叉树 */
    /* 看了题解，用哈希表可以提高查找的速度，不要用for循环 */
    private HashMap<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeWithIndex(preorder, inorder, 0);
    }

    private TreeNode buildTreeWithIndex(int[] preorder, int[] inorder, int startPoint) {
        if (preorder.length == 0) {
            return null;
        }
        int rootVal = preorder[0];
        int rootIndex = indexMap.get(rootVal) - startPoint;
        int leftLength = rootIndex;
        int rightLength = inorder.length - rootIndex - 1;
        if (leftLength != 0 && rightLength != 0) {
            int[] leftInorder = new int[leftLength];
            int[] leftPreorder = new int[leftLength];
            int[] rightInorder = new int[rightLength];
            int[] rightPreorder = new int[rightLength];
            System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
            System.arraycopy(inorder, rootIndex + 1, rightInorder, 0, rightLength);
            System.arraycopy(preorder, 1, leftPreorder, 0, leftLength);
            System.arraycopy(preorder, rootIndex + 1, rightPreorder, 0, rightLength);
            return new TreeNode(rootVal, buildTreeWithIndex(leftPreorder, leftInorder, startPoint),
                    buildTreeWithIndex(rightPreorder, rightInorder, startPoint + leftLength + 1));
        } else if (leftLength == 0 && rightLength == 0) {
            return new TreeNode(rootVal);
        } else if (leftLength == 0) {
            int[] rightInorder = new int[rightLength];
            int[] rightPreorder = new int[rightLength];
            System.arraycopy(inorder, 1, rightInorder, 0, rightLength);
            System.arraycopy(preorder, 1, rightPreorder, 0, rightLength);
            return new TreeNode(rootVal, null, buildTreeWithIndex(rightPreorder, rightInorder, startPoint + 1));
        } else if (rightLength == 0) {
            int[] leftInorder = new int[leftLength];
            int[] leftPreorder = new int[leftLength];
            System.arraycopy(inorder, 0, leftInorder, 0, leftLength);
            System.arraycopy(preorder, 1, leftPreorder, 0, leftLength);
            return new TreeNode(rootVal, buildTreeWithIndex(leftPreorder, leftInorder, startPoint), null);
        }
        return null;
    }
}