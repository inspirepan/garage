package algorithm.C1;

import datastructure.TreeNode;

public class S124 {

    class Solution {
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
        }

        int dfs(TreeNode node) {
            if (node == null) return 0;
            int left = dfs(node.left);
            int right = dfs(node.right);
            int res = 0;
            res = Math.max(node.val, node.val + left);
            res = Math.max(res, node.val + right);
            max = Math.max(max, Math.max(res, node.val + left + right));
            return res;
        }
    }
}