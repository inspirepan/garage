package algorithm.c4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class S444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // 根据seqs获取顺序
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int len = org.length;
        for (int i = 0; i < len; i++) {
            set.add(org[i]);
        }

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                int curr = seq.get(i);
                // 如果有没出现过的字符
                if (!set.contains(curr)) {
                    return false;
                }
                if (i > 0) {
                    // 前一个数字
                    int from = seq.get(i - 1);
                    List<Integer> next = map.getOrDefault(from, new ArrayList<>());
                    next.add(curr);
                    map.put(from, next);
                    indegree.put(curr, indegree.getOrDefault(curr, 0) + 1);
                } else {
                    indegree.putIfAbsent(curr, 0);
                }
            }
        }
        // 指针，将入度为0的数先算进来
        int ptr = 0;
        for (int i = 0; i < len; i++) {
            int curr = org[i];
            if (indegree.get(curr) == null) {
                return false;
            }
            if (indegree.get(curr) == 0) {
                ptr++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (ptr == i + 1) {
                int curr = org[i];
                if (map.get(curr) == null) {
                    continue;
                }
                for (int num : map.get(curr)) {
                    // 入度-1
                    indegree.put(num, indegree.get(num) - 1);
                    if (indegree.get(num) == 0) {
                        ptr++;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
