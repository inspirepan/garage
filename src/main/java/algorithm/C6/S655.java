package algorithm.C6;

import datastructure.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S655 {
    public List<List<String>> printTree(TreeNode root) {
        // 二叉树的宽度和层数是相关的啊
        int m = getHeight(root);
        int n = (1 << m) - 1;
        String[][] res = new String[m][n];
        for (String[] r : res) {
            Arrays.fill(r, "");
        }
        // 开始填充
        fill(root, res, 0, 0, n);
        List<List<String>> ans = new ArrayList<>();
        for (String[] r : res) {
            ans.add(Arrays.asList(r));
        }
        return ans;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private void fill(TreeNode node, String[][] res, int i, int l, int r) {
        if (node == null) {
            return;
        }
        int mid = l + (r - l) / 2;
        res[i][mid] = String.valueOf(node.val);
        fill(node.left, res, i + 1, l, mid);
        fill(node.right, res, i + 1, mid + 1, r);
    }
}
