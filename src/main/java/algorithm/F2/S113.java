package algorithm.F2;

import java.util.*;
import java.util.stream.IntStream;

public class S113 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray();
        }
        List<List<Integer>> map = new ArrayList<>();
        int j = numCourses;
        while (j-- > 0) {
            map.add(new ArrayList<>());
        }
        int[] count = new int[numCourses];
        for (var p : prerequisites) {
            // 需要先修的数量
            count[p[0]]++;
            map.get(p[1]).add(p[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        // 先把不需要先修的加进去
        for (int i = 0; i < numCourses; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int pos = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[pos++] = curr;
            for (int c : map.get(curr)) {
                count[c]--;
                // 当先修课程完成后
                if (count[c] == 0) {
                    queue.offer(c);
                }
            }
        }
        return pos == numCourses ? res : new int[0];
    }
}
