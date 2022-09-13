package algorithm.C6;

import datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int count = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int nextCount = 0;
            double sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            result.add(sum / (double) count);
            count = nextCount;
        }
        return result;
    }
}
