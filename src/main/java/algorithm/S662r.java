package algorithm;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class S662r {
    int ans;
    Map<Integer, Integer> left;

    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x -> pos);// 如果不存在就加入
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
