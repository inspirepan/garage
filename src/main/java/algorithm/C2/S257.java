package algorithm.C2;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S257 {
    List<String> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            var sb = new StringBuilder();
            for (Integer i : path) {
                sb.append(i);
                sb.append("->");
            }
            sb.append(node.val);
            res.add(sb.toString());
            return;
        }
        path.add(node.val);
        dfs(node.left);
        dfs(node.right);
        path.removeLast();
    }
}
