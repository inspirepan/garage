package algorithm.F1;

import datastructure.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S34 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        dfs(root, 0, target);
        return result;
    }

    private void dfs(TreeNode node, int curr, int target) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (curr + node.val == target) {
                var newPath = new ArrayList<>(path);
                newPath.add(node.val);
                result.add(newPath);
            }
            return;
        }
        path.add(node.val);
        dfs(node.left, curr + node.val, target);
        dfs(node.right, curr + node.val, target);
        path.removeLast();
    }
}
