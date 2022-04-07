package algorithm.C3;

import java.util.*;

public class S310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        if (n == 2) return List.of(0, 1);
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[n];
        List<List<Integer>> map = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        // 根据边统计入度、维护邻接表
        for (int[] edge : edges) {
            indegrees[edge[0]]++;
            indegrees[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        // 如果入度为1，加入删除队列
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 1)
                queue.offer(i);
        }
        // 循环删除
        while (!queue.isEmpty()) {
            level.clear();
            int currLevel = queue.size();
            for (int i = 0; i < currLevel; i++) {
                int node = queue.poll();
                level.add(node);
                for (int next : map.get(node)) {
                    indegrees[next]--;
                    if (indegrees[next] == 1)
                        queue.offer(next);
                }
            }
        }
        return level;
    }
}
