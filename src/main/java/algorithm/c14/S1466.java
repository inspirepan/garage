package algorithm.c14;

import java.util.*;

public class S1466 {
    public int minReorder(int n, int[][] connections) {
        Queue<Integer> vertex = new LinkedList<Integer>();
        // BFS辅助队列
        Map<Integer, HashSet<int[]>> graph = new HashMap<>();
        // 存储有向图的顶点以及关联的弧
        int ans = 0;
        for (int[] e : connections) {
            if (!graph.containsKey(e[0])) {
                graph.put(e[0], new HashSet<int[]>());
            }
            graph.get(e[0]).add(e);
            if (!graph.containsKey(e[1])) {
                graph.put(e[1], new HashSet<int[]>());
            }
            graph.get(e[1]).add(e);
        }
        vertex.offer(0);
        // 从顶点0开始遍历该有向图
        while (!vertex.isEmpty()) {
            int ver = vertex.poll();
            // 出队访问
            HashSet<int[]> hashtemp = graph.get(ver);
            // 暂存该顶点关联的所有边
            graph.remove(ver);
            // 从graph中移除已经访问过的顶点
            for (int[] e : hashtemp) {
                if (e[0] != ver && graph.containsKey(e[0])) {
                    vertex.offer(e[0]);
                }
                if (e[1] != ver && graph.containsKey(e[1])) {
                    // e[1]!=ver,说明e[0]=ver,则该边是逆向边
                    vertex.offer(e[1]);
                    ans++;
                }
            }
        }
        return ans;
    }
}

