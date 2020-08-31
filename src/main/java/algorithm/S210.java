package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class S210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray();
        }
        var list = new ArrayList<List<Integer>>();
        int j = numCourses;
        while (j-- > 0) {
            list.add(new ArrayList<>());
        }
        int[] count = new int[numCourses];
        for (var p : prerequisites) {
            count[p[0]]++;
            list.get(p[1]).add(p[0]);
        }
        var queue = new ArrayDeque<Integer>();
//        IntStream.range(0, numCourses).filter(i -> count[i] == 0).forEach(queue::offer);
//        为什么使用Stream会慢3ms啊
        for (int i = 0; i < numCourses; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int pos = 0;
        while (!queue.isEmpty()) {
            int curr = queue.pop();
            res[pos++] = curr;
            list.get(curr).forEach(c -> {
                count[c]--;
                if (count[c] == 0) {
                    queue.add(c);
                }
            });
        }
        return pos == numCourses ? res : new int[0];
    }
}
