package algorithm.C5;

import datastructure.TreeNode;

public class S563 {
    int tiltSum = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return tiltSum;
    }

    private int helper(TreeNode node) {
        // 返回树以及子树的和
        // 将树的val修改成坡度
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int temp = node.val;
        node.val = Math.abs(right - left);
        tiltSum += node.val;
        return left + right + temp;
    }
}
