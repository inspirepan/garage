package algorithm.c3;

import datastructure.TreeNode;

public class S333 {
    int ans = 1;

    public int largestBSTSubtree(TreeNode root) {
        // dfs的过程中需要保留子树的最大值和最小值，以及数量，以及是否为BST
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }

    int[] dfs(TreeNode node) {
        // 是否为BST
        // 子节点数量
        // 树最大值
        // 树最小值
        if (node.left == null && node.right == null) {
            return new int[]{1, 1, node.val, node.val};
        }
        int isBST = 0;
        int count = 1;
        int min = node.val;
        int max = node.val;
        if (node.left == null) {
            int[] r = dfs(node.right);
            if (r[0] != 0 && node.val < r[3]) {
                // 如果右子树是BST并且最小值大于当前节点，那么
                isBST = 1;
                count += r[1];
                min = node.val;
                max = r[2];
            }
        } else if (node.right == null) {
            int[] l = dfs(node.left);
            if (l[0] != 0 && node.val > l[2]) {
                isBST = 1;
                count += l[1];
                min = l[3];
                max = node.val;
            }
        } else {
            int[] l = dfs(node.left);
            int[] r = dfs(node.right);
            if (l[0] != 0 && r[0] != 0 && l[2] < node.val && r[3] > node.val) {
                isBST = 1;
                count += l[1] + r[1];
                min = l[3];
                max = r[2];
            }
        }
        ans = Math.max(ans, count);
        int[] result = {isBST, count, max, min};
        return result;
    }
}
