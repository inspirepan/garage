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

        int nextLevelCount = 0;
        int prevLevelCount = 1;
        int levelLeft = 1;
        int sum = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (levelLeft == 0) {
                result.add(sum / (double) prevLevelCount);
                levelLeft = nextLevelCount;
                prevLevelCount = nextLevelCount;
                sum = 0;
                nextLevelCount = 0;
            }

            levelLeft--;
            TreeNode curr = queue.poll();
            sum += curr.val;
            if (curr.left != null) {
                queue.offer(curr.left);
                nextLevelCount++;
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                nextLevelCount++;
            }
        }
        result.add(sum / (double) prevLevelCount);
        return result;
    }
}
