package algorithm.c14;

import java.util.*;

public class S1462 {
    private final Map<Integer, Set<Integer>> map = new HashMap<>();
    private final Set<Integer> dfsed = new HashSet<>();

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // 使用Set记录子节点
        // 使用dfs遍历全部子节点，每个节点加上下一层子节点的已经搜完的全部子节点列表
        List<Boolean> result = new ArrayList<>();
        for (var p : prerequisites) {
            var set = map.getOrDefault(p[0], new HashSet<>());
            set.add(p[1]);
            map.put(p[0], set);
        }
        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }
        for (var query : queries) {
            if (!map.containsKey(query[0])) {
                result.add(false);
            } else {
                result.add(map.get(query[0]).contains(query[1]));
            }
        }
        return result;
    }

    private void dfs(int i) {
        // i是节点
        if (!map.containsKey(i) || dfsed.contains(i)) {
            // 如果没有这个课程或者已经搜过，跳过
            return;
        }
        var child = map.get(i);
        if (child.size() == 0) {
            // 如果这是子节点
            dfsed.add(i);
            return;
        }
        var newChild = new HashSet<>(child);
        for (int c : child) {
            // 再向下搜
            dfs(c);
            dfsed.add(c);
            if (map.containsKey(c)) {
                newChild.addAll(map.get(c));
            }
        }
        map.put(i, newChild);
        dfsed.add(i);
    }
}
