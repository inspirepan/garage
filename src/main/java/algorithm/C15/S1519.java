package algorithm.C15;

import java.util.*;

public class S1519 {
    private Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] count;
    // 保存路径
    private Set<Integer> path = new HashSet<>();
    private Map<Character, List<Integer>> labelMap = new HashMap<>();
    String labels;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // 还是一个搜索的思想
        // 处理无向图要用一个Map保存边
        // 艹，直接搜索遍历还能超时的啊，那我也不知道怎么做了

        // 用dfs的函数向上传结果
        this.count = new int[n];
        this.labels = labels;
        char[] cA = labels.toCharArray();
        // 每个字符出现的位置
        for (int i = 0, len = cA.length; i < len; i++) {
            char c = cA[i];
            var list = labelMap.getOrDefault(c, new ArrayList<>());
            list.add(i);
            labelMap.put(c, list);
        }
        for (int[] edge : edges) {
            // 两个节点各保存一次
            var set0 = map.getOrDefault(edge[0], new HashSet<>());
            set0.add(edge[1]);
            map.put(edge[0], set0);
            var set1 = map.getOrDefault(edge[1], new HashSet<>());
            set1.add(edge[0]);
            map.put(edge[1], set1);
        }
        dfs(0);
        return count;
    }

    private void dfs(int i) {
        // 从零开始找，那么往下找肯定是子节点

        path.add(i);
        var list = labelMap.get(this.labels.charAt(i));
        // 如果父路径中有和当前字符一样的
        for (int k : list) {
            if (path.contains(k)) {
                count[k]++;
            }
        }
        if (!map.containsKey(i) || map.get(i).isEmpty()) {
            // 叶子，count只能是1
            count[i] = 1;
        } else {
            // 有子节点
            var set = map.get(i);
            for (int j : set) {
                // 移除父节点
                map.get(j).remove(i);
                dfs(j);
            }
        }
        path.remove(i);
    }

    // 看得题解

    public int[] countSubTrees2(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            // 一样的，建立双向边，我用的还是Set
            int node0 = edge[0], node1 = edge[1];
            List<Integer> list0 = edgesMap.getOrDefault(node0, new ArrayList<Integer>());
            List<Integer> list1 = edgesMap.getOrDefault(node1, new ArrayList<Integer>());
            list0.add(node1);
            list1.add(node0);
            edgesMap.put(node0, list0);
            edgesMap.put(node1, list1);
        }
        int[] counts = new int[n];
        boolean[] visited = new boolean[n];
        depthFirstSearch(0, counts, visited, edgesMap, labels);
        return counts;
    }

    public int[] depthFirstSearch(int node, int[] counts, boolean[] visited, Map<Integer, List<Integer>> edgesMap, String labels) {
        // 传一个数组作为结果就行了，把每个节点当成根节点这样子搞
        visited[node] = true;
        int[] curCounts = new int[26];
        curCounts[labels.charAt(node) - 'a']++;
        List<Integer> nodesList = edgesMap.get(node);
        for (int nextNode : nodesList) {
            if (!visited[nextNode]) {
                // 如果没有访问过
                int[] childCounts = depthFirstSearch(nextNode, counts, visited, edgesMap, labels);
                for (int i = 0; i < 26; i++) {
                    curCounts[i] += childCounts[i];
                }
            }
        }
        // counts是最终的结果
        counts[node] = curCounts[labels.charAt(node) - 'a'];
        return curCounts;
    }
}
