package algorithm.C6;

import datastructure.TreeNode;

public class S654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        int partition = maxIndex(nums, l, r);
        TreeNode node = new TreeNode(nums[partition]);
        node.left = helper(nums, l, partition - 1);
        node.right = helper(nums, partition + 1, r);
        return node;
    }

    public int maxIndex(int[] nums, int l, int r) {
        // 求数组[l,r]的最大值，没什么技巧，只能遍历
        int max = Integer.MIN_VALUE, index = l;
        while (l <= r) {
            if (nums[l] > max) {
                max = nums[l];
                index = l;
            }
            l++;
        }
        return index;
    }
}
