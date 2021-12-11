package algorithm.S101to200;

import datastructure.TreeNode;

public class S108 {
    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }

    private TreeNode build(int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) >>> 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(start, mid - 1);
        root.right = build(mid + 1, end);
        return root;
    }
}