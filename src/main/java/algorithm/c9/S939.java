package algorithm.c9;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S939 {
    class Solution {
        public int minAreaRect(int[][] points) {
            Set<Integer> set = new HashSet<>();
            int res = Integer.MAX_VALUE;
            final int MAX = 40000;
            for (int[] point : points) {
                for (int[] anotherPoint : points) {
                    if (point[0] == anotherPoint[0] || point[1] == anotherPoint[1])
                        continue;
                    if (set.contains(point[0] * MAX + anotherPoint[1]) && set.contains(anotherPoint[0] * MAX + point[1]))
                        res = Math.min(res, Math.abs((point[0] - anotherPoint[0]) * (point[1] - anotherPoint[1])));
                }
                set.add(point[0] * MAX + point[1]);
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
}
