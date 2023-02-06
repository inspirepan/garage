package algorithm.c1;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> level = new ArrayList<>();
        Deque<TreeNode> currLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();
        currLevel.offer(root);
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
            result.add(new ArrayList<>(level));
            level.clear();
        }
        // add the most down level
        // since the loop will immediately stop after last node polled
        result.add(new ArrayList<>(level));
        return result;
    }
}
