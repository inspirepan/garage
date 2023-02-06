package algorithm.c3;

import datastructure.TreeNode;

import java.util.*;

public class S314 {
    List<List<Integer>> result = new ArrayList<>();
    int min = 0;
    int max = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return result;
        }

        // 层序
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                TreeNode node = n.treeNode;
                int index = n.index;
                min = Math.min(min, index);
                max = Math.max(max, index);
                var list = map.getOrDefault(index, new ArrayList<>());
                list.add(node.val);
                map.put(index, list);
                if (node.left != null) {
                    queue.offer(new Node(node.left, index - 1));
                }
                if (node.right != null) {
                    queue.offer(new Node(node.right, index + 1));
                }
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    class Node {
        TreeNode treeNode;
        int index;

        Node(TreeNode tn, int idx) {
            this.treeNode = tn;
            this.index = idx;
        }
    }
}
