package algorithm.C3;

import java.util.*;

public class S310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[n];
        List<List<Integer>> adjacency = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        // 如果只有一个数
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        // 空的二维List
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 根据边统计入度、维护邻接表
        for (int[] edge : edges) {
            indegrees[edge[0]]++;
            indegrees[edge[1]]++;
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }
        // 如果入度为1，加入删除队列
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 1)
                queue.offer(i);
        }
        // 循环删除
        while (!queue.isEmpty()) {
            ans = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                ans.add(cur);
                // 它的邻居
                List<Integer> a = adjacency.get(cur);
                for (int tmp : a) {
                    indegrees[tmp]--;
                    if (indegrees[tmp] == 1)
                        queue.offer(tmp);
                }
            }
        }
        // ans就是最后一次while循环中queue中的节点
        return ans;
    }
}
