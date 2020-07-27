package algorithm;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import dataStructure.TreeNode;

public class S102 {
    /*
     * 层序遍历， BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int currentLevelcount = 0;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null)
            return ans;
        ans.add(new ArrayList<>(Arrays.asList(root.val)));
        queue.add(root);
        currentLevelcount = queue.size();
        while (currentLevelcount != 0) {
            List<Integer> currentLevelResult = new ArrayList<>();
            for (int i = 0; i < currentLevelcount; i++) {
                TreeNode top = queue.pop();
                if (top.left != null)
                    queue.add(top.left);
                if (top.right != null)
                    queue.add(top.right);
                currentLevelResult.add(top.val);
            }
            currentLevelcount = queue.size();
            ans.add(currentLevelResult);
        }
        ans.remove(0);
        return ans;
    }
}