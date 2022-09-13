package algorithm.C3;

import java.util.ArrayList;
import java.util.List;

public class S315bst {
    // 二叉的效率不行，还不如On2的插入排序。二叉会超时
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        int[] r = new int[nums.length];
        r[r.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            System.out.println();
            addNode(root, nums[i], r, i);
        }
        for (int i = 0; i < nums.length; i++) {
            res.add(r[i]);
        }
        return res;
    }

    TreeNode addNode(TreeNode node, int val, int[] r, int index) {
        if (node == null) {
            return new TreeNode(val);
        }
        System.out.println(node.val + " " + node.leftCount);
        if (val <= node.val) {
            node.leftCount++;
            node.left = addNode(node.left, val, r, index);
        } else {
            r[index] += node.leftCount + 1;
            node.right = addNode(node.right, val, r, index);
        }
        return node;
    }

    static class TreeNode {
        int val;
        int leftCount = 0;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            this.val = v;
        }
    }
}
