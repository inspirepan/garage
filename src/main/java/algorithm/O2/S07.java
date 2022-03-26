package algorithm.O2;

import datastructure.TreeNode;

public class S07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return helper(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    private TreeNode helper(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr || il > ir) return null;
        if (pl == pr && il == ir) {
            return new TreeNode(preorder[pl]);
        }
        int rootVal = preorder[pl];
        int index = find(inorder, il, ir, rootVal);
        int leftSize = index - il;
        int rightSize = ir - index;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, pl + 1, pl + leftSize, inorder, il, il + leftSize - 1);
        root.right = helper(preorder, pl + leftSize + 1, pr, inorder, ir - rightSize + 1, ir);
        return root;
    }

    private int find(int[] inorder, int il, int ir, int target) {
        // [il, ir]
        while (il <= ir) {
            if (inorder[il] == target) return il;
            il++;
        }
        return -1;
    }
}
