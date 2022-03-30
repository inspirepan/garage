package algorithm.C7;

import java.util.*;

public class S797 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Map<Integer, List<Integer>> map;
    int target;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 没什么难度的dfs
        map = new HashMap<>();
        target = graph.length - 1;
        for (int i = 0; i < graph.length; i++) {
            int[] next = graph[i];
            List<Integer> nextList = new ArrayList<>();
            for (int n : next) nextList.add(n);
            map.put(i, nextList);
        }
        dfs(0);
        return res;
    }

    void dfs(int i) {
        path.add(i);
        if (i == target) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        var next = map.get(i);
        for (int n : next) {
            dfs(n);
        }
        path.remove(path.size() - 1);
    }
}
