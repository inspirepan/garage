package algorithm.c7;

import java.util.*;

public class S721bfs {
    // 记忆化广搜还是超时了
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 有可能一开始两条记录是不相关的，但是有第三条记录让他们两个相关了 要用广搜或者深搜
        // 首先统计各个名字出现的次数，如果只出现一次，就不需要处理
        // 然后大于一次的，在相同名称的email列表中，做一个并查集
        List<List<String>> result = new ArrayList<>();
        // name， emails
        Map<String, List<Set<String>>> map = new HashMap<>();
        for (var a : accounts) {
            String name = a.get(0);
            var list = map.getOrDefault(name, new ArrayList<>());
            Set<String> emails = new HashSet<>();
            for (int i = 1; i < a.size(); i++) {
                emails.add(a.get(i));
            }
            list.add(emails);
            map.put(name, list);
        }
        for (var e : map.entrySet()) {
            // val中有多条name相同的Set<String>
            List<List<String>> combined = helper(e.getKey(), e.getValue());
            result.addAll(combined);
        }
        return result;
    }

    private List<List<String>> helper(String name, List<Set<String>> emailSets) {
        // 只出现一次
        if (emailSets.size() == 1) {
            LinkedList<String> sorted = new LinkedList<>(emailSets.get(0));
            Collections.sort(sorted);
            sorted.addFirst(name);
            return Collections.singletonList(sorted);
        }
        int size = emailSets.size();
        // 先统计每个email出现的index
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (String email : emailSets.get(i)) {
                var list = map.getOrDefault(email, new ArrayList<>());
                list.add(i);
                map.put(email, list);
            }
        }
        // 使用广度优先搜索将账户分组
        int[] groups = new int[size];
        Arrays.fill(groups, -1);
        // -1代表没有分组
        int groupIndex = 0;
        for (int i = 0; i < size; i++) {
            if (groups[i] == -1) {
                // 新的未分组的
                // 找到全部关联的
                Deque<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int k = queue.poll();
                    // 标记当前分组
                    groups[k] = groupIndex;
                    // 它包含全部的email
                    var set = emailSets.get(k);
                    for (String email : set) {
                        // 与这个email关联的全部索引
                        var list = map.get(email);
                        for (int m : list) {
                            if (groups[m] == -1) {
                                queue.offer(m);
                            }
                        }
                    }
                }
                groupIndex++;
            }
        }
        // 根据分组建立新的list，使用HashSet去重
        List<Set<String>> resultUnsorted = new ArrayList<>();
        for (int k = 0; k < groupIndex; k++) {
            resultUnsorted.add(new HashSet<>());
        }
        for (int i = 0; i < size; i++) {
            int group = groups[i];
            Set<String> emails = emailSets.get(i);
            resultUnsorted.get(group).addAll(emails);
        }
        // 排序
        List<List<String>> res = new ArrayList<>();
        for (int k = 0; k < groupIndex; k++) {
            LinkedList<String> t = new LinkedList<>(resultUnsorted.get(k));
            Collections.sort(t);
            t.addFirst(name);
            res.add(t);
        }
        return res;
    }
}
