package algorithm.C7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class S752 {
    public int openLock(String[] deadends, String target) {
        // 强行广搜，效果还是不错的 65%
        Set<String> set = new HashSet<>();
        for (String d : deadends) {
            set.add(d);
        }

        // if target or start is deadend
        if (set.contains(target) || set.contains("0000")) {
            return -1;
        }
        // if target is start
        if ("0000".equals(target)) {
            return 0;
        }
        // BFS
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int currSize = 1, step = 1;
        while (!queue.isEmpty()) {
            int nextSize = 0;
            for (int i = 0; i < currSize; i++) {
                String curr = queue.poll();
                String[] nexts = getNext(curr);
                for (String next : nexts) {
                    if (target.equals(next)) {
                        return step;
                    }
                    if (set.contains(next) || visited.contains(next)) {
                        continue;
                    }
                    nextSize++;
                    visited.add(next);
                    queue.offer(next);
                }
            }
            currSize = nextSize;
            step++;
        }
        return -1;
    }

    private String[] getNext(String curr) {
        String[] res = new String[8];
        char[] chars = curr.toCharArray();
        for (int i = 0; i < 4; i++) {
            char t = chars[i];
            chars[i] = t == '9' ? '0' : (char) (t + 1);
            res[i << 1] = new String(chars);
            chars[i] = t == '0' ? '9' : (char) (t - 1);
            res[(i << 1) + 1] = new String(chars);
            chars[i] = t;
        }
        return res;
    }
}
