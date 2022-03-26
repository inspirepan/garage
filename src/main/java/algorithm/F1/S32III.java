package algorithm.F1;

import datastructure.TreeNode;

import java.util.*;

public class S32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> currLevel = new LinkedList<>();
        currLevel.offer(root);
        boolean left = true;
        while (!currLevel.isEmpty()) {
            LinkedList<Integer> levelList = new LinkedList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            for (int i = 0; i < currLevel.size(); i++) {
                TreeNode node = currLevel.get(i);
                if (left) {
                    levelList.add(node.val);
                } else {
                    levelList.addFirst(node.val);
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            list.add(levelList);
            currLevel = nextLevel;
            left = !left;
        }
        return list;
    }
}
