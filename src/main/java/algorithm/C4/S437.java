package algorithm.C4;

import datastructure.TreeNode;

import java.util.*;

public class S437 {
    Map<Integer, List<TreeNode>> trie = new HashMap<>();
    Set<TreeNode> path = new HashSet<>();
    int count = 0;
    int target = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和
        // 实际上没有必要记录节点，只需要记录前缀和出现的次数，手动加减这个次数就可以了
        if (root == null) return 0;
        target = targetSum;
        dfs(root, 0);
        // 再来一遍
        return count;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        System.out.println(node.val + " " + count);
        sum += node.val;
        if (sum == target) count++;
        if (trie.containsKey(sum - target)) {
            var list2 = trie.get(sum - target);
            for (TreeNode node2 : list2) {
                if (path.contains(node2)) count++;
            }
        }
        System.out.println(node.val + " " + count);
        List<TreeNode> list = trie.getOrDefault(sum, new ArrayList<>());
        list.add(node);
        trie.put(sum, list);
        path.add(node);
        dfs(node.left, sum);
        dfs(node.right, sum);
        path.remove(node);
    }
}
