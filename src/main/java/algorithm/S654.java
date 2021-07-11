package algorithm;

import datastructure.TreeNode;

public class S654 {
    // 感觉没啥技术含量，找最大值就是靠遍历啊
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }

    public TreeNode maxTree(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        //bond为当前数组中最大值的索引
        int bond = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[bond]);
        root.left = maxTree(nums, l, bond - 1);
        root.right = maxTree(nums, bond + 1, r);
        return root;
    }
    //找最大值的索引
    public int findMax(int[] nums, int l, int r){
        int max = Integer.MIN_VALUE, maxIndex = l;
        for(int i = l; i <= r; i++){
            if(max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
