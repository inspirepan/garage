package algorithm.f2;

import java.util.*;

public class S108 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // endWord必须要在wordList中
        // 广度优先搜索，可以计算先计算wordList中可以进行转换的对子（只相差一个字母）
        // 然后每次将编辑距离为1的词加入queue进行BFS

        // 构建边
        Map<String, Set<String>> map = new HashMap<>();
        map.put(beginWord, new HashSet<>());
        for (int i = 0; i < wordList.size(); i++) {
            String wordA = wordList.get(i);
            if (!map.containsKey(wordA)) {
                map.put(wordA, new HashSet<>());
            }
            if (neighbor(wordA, beginWord)) {
                map.get(beginWord).add(wordA);
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                String wordB = wordList.get(j);
                if (neighbor(wordA, wordB)) {
                    var setA = map.get(wordA);
                    setA.add(wordB);
                    var setB = map.getOrDefault(wordB, new HashSet<>());
                    setB.add(wordA);
                    map.put(wordA, setA);
                    map.put(wordB, setB);
                }
            }
        }
        // 如果相连
        if (map.get(beginWord).contains(endWord)) {
            return 2;
        }
        if (!map.containsKey(endWord)) {
            return 0;
        }

        // 开始bfs
        Set<String> used = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int length = 1;
        int currCount = 1;
        while (!queue.isEmpty()) {
            int nextCount = 0;
            for (int i = 0; i < currCount; i++) {
                String curr = queue.poll();
                if (!map.containsKey(curr)) {
                    continue;
                }
                var set = map.get(curr);
                if (set.size() == 0) {
                    continue;
                }
                if (set.contains(endWord)) {
                    return length + 1;
                }
                for (String next : set) {
                    // 下一个
                    if (used.contains(next)) {
                        continue;
                    }
                    // 添加到queue
                    queue.offer(next);
                    nextCount++;
                    used.add(next);
                }
            }
            length++;
            currCount = nextCount;
        }
        return 0;
    }

    private boolean neighbor(String a, String b) {
        int count = 0;
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
