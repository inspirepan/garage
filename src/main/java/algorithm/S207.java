package algorithm;

import java.util.*;

public class S207 {
    /**
     * 思路是记录每一门课程需要先修的课程数量，找到先修数为0的放入队列，然后把所有需要先修这门课的计数-1，如果到0就放进队列。
     * 最后遍历一轮如果有非0的说明无法修这门课。
     * 优化：使用List<List>替代Map
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        int[] prerequisiteCount = new int[numCourses];
        var prerequisiteList = new ArrayList<List<Integer>>();
        int k = numCourses;
        while (k-- != 0) {
            prerequisiteList.add(new ArrayList<>());
        }
        for (var prerequisite : prerequisites) {
            prerequisiteCount[prerequisite[0]]++;
            prerequisiteList.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < prerequisiteCount.length; i++) {
            if (prerequisiteCount[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            numCourses--;
            var list = prerequisiteList.get(curr);
            if (list != null) {
                list.forEach(i -> {
                    prerequisiteCount[i]--;
                    if (prerequisiteCount[i] == 0) {
                        queue.offer(i);
                    }
                });
            }

        }
        return numCourses == 0;
    }
}
