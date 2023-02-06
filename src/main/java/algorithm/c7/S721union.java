package algorithm.c7;

import java.util.*;

public class S721union {
    private final Map<String, Integer> emailIndex = new HashMap<>();
    private final Map<String, String> emailName = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        Graph g = new Graph(10001);
        int index = 0;
        for (int i = 0; i < len; i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailIndex.containsKey(email)) {
                    emailIndex.put(email, index++);
                    emailName.put(email, name);
                }
            }
        }

        // 同一个账户的邮箱合并
        for (List<String> account : accounts) {
            String email = account.get(1);
            int firstIndex = emailIndex.get(email);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String newEmail = account.get(i);
                int newIndex = emailIndex.get(newEmail);
                g.union(firstIndex, newIndex);
            }
        }

        Map<Integer, LinkedList<String>> groupMap = new HashMap<>();
        for (String email : emailIndex.keySet()) {
            // 对于每一个email
            int groupIndex = g.find(emailIndex.get(email));
            LinkedList<String> groupList = groupMap.getOrDefault(groupIndex, new LinkedList<>());
            groupList.add(email);
            groupMap.put(groupIndex, groupList);
        }

        List<List<String>> res = new ArrayList<>();
        for (LinkedList<String> groupList : groupMap.values()) {
            Collections.sort(groupList);
            String name = emailName.get(groupList.get(0));
            groupList.addFirst(name);
            res.add(groupList);
        }
        return res;
    }

    // 并查集
    static class Graph {
        int[] root;
        int[] level;

        public Graph(int m) {
            root = new int[m];
            level = new int[m];
            for (int i = 0; i < m; i++) {
                root[i] = i;
            }
            Arrays.fill(level, 1);
        }

        public int find(int x) {
            // 寻找根节点
            if (x != root[x]) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int root1, int root2) {
            // 合并两个组
            int a = find(root1);
            int b = find(root2);
            if (a != b) {
                if (level[a] == level[b]) {
                    root[a] = b;
                    level[b]++;
                } else if (level[a] > level[b]) {
                    root[b] = a;
                } else {
                    root[a] = b;
                }
            }
        }
    }
}
