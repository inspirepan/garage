package algorithm;

import java.util.*;

import datastructure.TreeNode;

public class S102 {
    /*
     * 层序遍历， BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        queue.add(root);
        int currentLevelCount = queue.size();
        while (currentLevelCount != 0) {
            List<Integer> currentLevelResult = new ArrayList<>();
            for (int i = 0; i < currentLevelCount; i++) {
                TreeNode top = queue.pop();
                if (top.left != null)
                    queue.add(top.left);
                if (top.right != null)
                    queue.add(top.right);
                currentLevelResult.add(top.val);
            }
            currentLevelCount = queue.size();
            ans.add(currentLevelResult);
        }
        return ans;
    }
}