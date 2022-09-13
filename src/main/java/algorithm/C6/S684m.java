package algorithm.C6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class S684m {

    boolean founded = false;
    LinkedList<Integer> path = new LinkedList<>();
    Set<Integer> ring = new HashSet<>();
    boolean[] visited;
    Map<Integer, Set<Integer>> map;

    public int[] findRedundantConnection(int[][] edges) {
        // 图论啥的我都不知道，只会dfs
        // 3.20自己写的
        int n = edges.length;
        // 邻接表
        this.map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            var as = map.getOrDefault(a, new HashSet<>());
            as.add(b);
            map.put(a, as);
            var bs = map.getOrDefault(b, new HashSet<>());
            bs.add(a);
            map.put(b, bs);
        }
        // 深度优先搜索环
        this.visited = new boolean[n + 1];
        dfs(1, -1);
        // 找到环中的全部节点 ring
        for (int i = n - 1; i >= 0; i--) {
            int[] edge = edges[i];
            if (ring.contains(edge[0]) && ring.contains(edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private void dfs(int node, int from) {
        // 如果当前节点访问过，说明已经找到环了，结束
        if (visited[node]) {
            founded = true;
            // 提取环，从node到最后
            ring = new HashSet<>();
            boolean inRing = false;
            for (int p : path) {
                if (p == node) {
                    inRing = true;
                    ring.add(p);
                } else if (inRing) {
                    ring.add(p);
                }
            }
            return;
        }
        if (founded) {
            return;
        }
        path.add(node);
        visited[node] = true;
        for (int neighbor : map.get(node)) {
            if (neighbor == from) {
                continue;
            }
            dfs(neighbor, node);
        }
        visited[node] = false;
        path.removeLast();
    }
}
