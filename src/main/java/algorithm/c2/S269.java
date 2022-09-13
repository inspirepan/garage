package algorithm.c2;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class S269 {
    public String alienOrder(String[] words) {
        // 每次比较相邻的两个单词，得到一条有向边
        // 然后再根据课程顺序那道题的方法给出一个排序就可以了
        // 有向边
        Map<Character, Set<Character>> map = new HashMap<>();
        // 入度
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
            }
        }
        //比较相邻的就可以了
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int k = 0;
            // 依次按位比较获取关系
            int minLen = Math.min(w1.length(), w2.length());
            while (k < minLen) {
                char c1 = w1.charAt(k);
                char c2 = w2.charAt(k);
                if (c1 == c2) {
                    // 原字母序有误
                    if (k == minLen - 1 && w1.length() > w2.length()) {
                        return "";
                    }
                } else {
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
                k++;
            }
        }
        var sb = new StringBuilder();
        Deque<Character> queue = new LinkedList<>();
        for (var e : indegree.entrySet()) {
            if (e.getValue() == 0) {
                queue.offer(e.getKey());
            }
        }
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            if (map.containsKey(curr)) {
                for (char next : map.get(curr)) {
                    int in = indegree.get(next) - 1;
                    if (in == 0) {
                        queue.offer(next);
                    }
                    indegree.put(next, in);
                }
            }
        }

        for (var val : indegree.values()) {
            if (val > 0) {
                return "";
            }
        }
        return sb.toString();
    }
}
