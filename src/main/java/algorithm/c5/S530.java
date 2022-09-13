package algorithm.c5;

import datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class S530 {
    public int getMinimumDifference(TreeNode root) {
        // 既然是BST，那么中序遍历然后找有序数组中的最小差值就可以了
        int min = Integer.MAX_VALUE;
        int prev = -10001;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val == prev) {
                return 0;
            }
            min = Math.min(node.val - prev, min);
            prev = node.val;
            node = node.right;
        }
        return min;
    }
}
