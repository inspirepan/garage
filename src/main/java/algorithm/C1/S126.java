package algorithm.C1;

import java.util.*;

public class S126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 先构建距离为1的单词映射表
        // on2构建吗？
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> beginWordSet = new HashSet<>();
        for (String s : wordList) {
            map.put(s, new HashSet<>());
            if (isNeighbor(beginWord, s)) {
                beginWordSet.add(s);
            }
        }
        map.put(beginWord, beginWordSet);
        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String a = wordList.get(i);
                String b = wordList.get(j);
                if (isNeighbor(a, b)) {
                    map.get(a).add(b);
                    map.get(b).add(a);
                }
            }
        }
        // 判断endWord是否在wordList中，是否有转换对象，以及它和beginWord的距离
        List<List<String>> res = new ArrayList<>();
        if (!map.containsKey(endWord)) return res;
        if (isNeighbor(beginWord, endWord)) {
            res.add(List.of(beginWord, endWord));
            return res;
        }

        // 然后从beginWord开始BFS
        // 直到某一级找到了endWord
        Deque<List<String>> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.add(List.of(beginWord));
        while (!queue.isEmpty()) {
            Deque<List<String>> nextQueue = new ArrayDeque<>();
            boolean found = false;
            Set<String> levelNewVisited = new HashSet<>();
            while (!queue.isEmpty()) {
                var curr = queue.poll();

                String last = curr.get(curr.size() - 1);
                for (String next : map.get(last)) {
                    if (visited.contains(next)) continue;
                    // 不能重复访问一个词，但是同一层级可以访问
                    levelNewVisited.add(next);
                    var nextList = new ArrayList<>(curr);
                    nextList.add(next);
                    nextQueue.offer(nextList);
                    if (next.equals(endWord)) {
                        found = true;
                        res.add(nextList);
                    }
                }
            }
            if (found) {
                break;
            }
            visited.addAll(levelNewVisited);
            queue = nextQueue;
        }
        return res;
    }

    boolean isNeighbor(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int cnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}
