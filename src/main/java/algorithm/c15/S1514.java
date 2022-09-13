package algorithm.c15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S1514 {
    double[] succProb;
    boolean[] visited;
    Map<Integer, List<int[]>> map = new HashMap<>();
    double maxProb = 0;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // 也就是一个无向图遍历的题目
        // 用dfs会超时
        // 还是会超时啊，剪掉了小于1e5概率的边也不行
        // 还是要用算法，毕竟我们只是求一条最佳路径，不能呆板地遍历整个图

        // 突然发现这道题是标准迪杰斯特拉，可以用算法啊
        this.succProb = succProb;
        this.visited = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            // 每个结点：下一个结点、对应边的序号
            var list0 = map.getOrDefault(edges[i][0], new ArrayList<>());
            list0.add(new int[] {edges[i][1], i});
            map.put(edges[i][0], list0);
            var list1 = map.getOrDefault(edges[i][1], new ArrayList<>());
            list1.add(new int[] {edges[i][0], i});
            map.put(edges[i][1], list1);
        }
        dfs(start, end, 1);
        return maxProb;
    }

    private void dfs(int i, int target, double prob) {
        //
        if (i == target) {
            maxProb = Math.max(prob, maxProb);
            return;
        }
        this.visited[i] = true;
        if (!map.containsKey(i)) {
            return;
        }
        var list = map.get(i);
        for (var pair : list) {
            if (visited[pair[0]]) {
                // 访问过的节点
                continue;
            }
            if (prob * this.succProb[pair[1]] < 1e-5) {
                // 加上这个剪枝还是不行
                continue;
            }
            // 访问这个结点
            dfs(pair[0], target, prob * this.succProb[pair[1]]);
        }
        this.visited[i] = false;
    }
}
