package algorithm.c5;

import datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        int levelSum = 1;
        int nextLevelSum = 0;
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < levelSum; i++) {
                var node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextLevelSum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextLevelSum++;
                }
            }
            result.add(max);
            levelSum = nextLevelSum;
            nextLevelSum = 0;
        }
        return result;
    }
}
