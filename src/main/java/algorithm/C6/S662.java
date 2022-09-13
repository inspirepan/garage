package algorithm.C6;

import datastructure.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class S662 {
    // depth, firstLeft
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public int widthOfBinaryTree(TreeNode root) {
        // 每层都来一个序号，
        dfs(root, 1, 0);
        return max;
    }

    private void dfs(TreeNode node, int depth, int pos) {
        if (node == null) {
            return;
        }
        int left = pos;
        // 每层最左边的节点序号
        if (map.containsKey(depth)) {
            left = map.get(depth);
        } else {
            map.put(depth, pos);
        }
        max = Math.max(max, pos - left + 1);
        dfs(node.left, depth + 1, 2 * pos);
        dfs(node.right, depth + 1, 2 * pos + 1);
    }
}
