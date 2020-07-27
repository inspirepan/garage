package algorithm;

import java.util.*;

import dataStructure.TreeNode;

public class S102 {
    /*
     * 层序遍历， BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int currentLevelCount = 0;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null)
            return ans;
        ans.add(new ArrayList<>(Collections.singletonList(root.val)));
        queue.add(root);
        currentLevelCount = queue.size();
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
        ans.remove(0);
        return ans;
    }
}