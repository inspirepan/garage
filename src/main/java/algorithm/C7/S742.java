package algorithm.C7;

import datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S742 {

    // 直接用二叉树做太麻烦了，需要统计每个节点左边最近的叶子节点、右边最近的叶子节点，左边的高度、右边的高度，不如转换成图来做
    public int findClosestLeaf(TreeNode root, int k) {
        // 转换成图，二叉树每个节点最多3个邻居
        // 注意根节点的特殊性
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int[][] graph = new int[1001][3];
        for (int[] n : graph) {
            Arrays.fill(n, -1);
        }
        dfs(root, -1, graph);
        // bfs找到最近的叶子节点
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        int[] visited = new int[1001];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = 1;
            int neighborCount = 0;
            for (int i = 0; i < 3; i++) {
                int neighbor = graph[node][i];
                if (neighbor != -1) {
                    neighborCount++;
                    if (visited[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
            if (neighborCount == 1 && node != root.val) {
                return node;
            }
        }
        return -1;
    }

    private void dfs(TreeNode root, int parent, int[][] graph) {
        if (root == null) {
            return;
        }
        graph[root.val][0] = parent;
        graph[root.val][1] = val(root.left);
        graph[root.val][2] = val(root.right);
        dfs(root.left, root.val, graph);
        dfs(root.right, root.val, graph);
    }

    private int val(TreeNode node) {
        return node == null ? -1 : node.val;
    }
}
