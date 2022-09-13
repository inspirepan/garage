package algorithm.C1;

import datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class S103 {
    /**
     * use code from S102
     * using reverse to choose direction
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> level = new ArrayList<>();
        Deque<TreeNode> currLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();
        currLevel.offer(root);
        boolean reverse = false;
        while (!currLevel.isEmpty() || !nextLevel.isEmpty()) {
            if (!currLevel.isEmpty()) {
                TreeNode node = currLevel.poll();
                if (node.left != null) {
                    nextLevel.offer(node.left);
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
                level.add(node.val);
                continue;
            }
            currLevel.addAll(nextLevel);
            nextLevel.clear();
            if (reverse) {
                Collections.reverse(level);
            }
            result.add(new ArrayList<>(level));
            reverse = !reverse;
            level.clear();
        }
        // add the most down level
        // since the loop will immediately stop after last node polled
        if (reverse) {
            Collections.reverse(level);
        }
        result.add(new ArrayList<>(level));
        return result;
    }
}