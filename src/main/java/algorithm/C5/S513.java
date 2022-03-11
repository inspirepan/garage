package algorithm.C5;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class S513 {

    public int findBottomLeftValue(TreeNode root) {
        // 直接层序遍历
        // 实际上可以更加灵活，每层从右往左遍历，这样子直接返回最后一个节点的val就可以了，
        // 都不用统计每层节点的数量
        if (root == null) return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        int levelSum = 1;
        int nextLevelSum = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < levelSum; i++) {
                var node = queue.poll();
                if (i == 0) result = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelSum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelSum++;
                }
            }
            levelSum = nextLevelSum;
            nextLevelSum = 0;
        }
        return result;
    }
}
