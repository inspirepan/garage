package algorithm.C7;

import java.util.*;

public class S797 {
    class Solution {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[][] graph;
        int n;
        boolean[] visited;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            this.n = graph.length;
            this.graph = graph;
            // DFS
            visited = new boolean[n];
            visited[0] = true;
            path.add(0);
            dfs(0);
            return result;
        }

        void dfs(int p) {
            if (p == n - 1) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int next : graph[p]) {
                if (!visited[next]) {
                    path.add(next);
                    dfs(next);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
