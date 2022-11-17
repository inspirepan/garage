package algorithm.c10;

import datastructure.TreeNode;

/**
 * @author : panjixiang
 * @since : 2022/11/17
 */
public class S1008 {
    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, 0, preorder.length - 1);
        }

        private TreeNode helper(int[] o, int left, int right) {
            if (left > right) {
                return null;
            }
            var root = new TreeNode(o[left]);
            int partition = binarySearch(o, o[left], left + 1, right);
            root.left = helper(o, left + 1, partition - 1);
            root.right = helper(o, partition, right);
            return root;
        }

        private int binarySearch(int[] nums, int target, int left, int right) {

            // 1 3 2
            // 5 1 7
            //
            while (left <= right) {
                int mid = left + (right - left) / 2;
                System.out.println(left + " " + right + " " + mid);
                // 不会有等于的情况
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
