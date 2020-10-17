package algorithm;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class S530 {
    /**
     * 计算二叉搜索树任意两结点差值绝对值的最小值
     */
    public int getMinimumDifference(TreeNode root) {
        int minDifference = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        int prevVal = 0;
        boolean first = true;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (first) {
                first = false;
            } else {
                minDifference = Math.min(node.val - prevVal, minDifference);
            }
            prevVal = node.val;
            node = node.right;
        }
        return minDifference;
    }
}
