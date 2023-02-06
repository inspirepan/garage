package algorithm.c9;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : panjixiang
 * @since : 2022/9/23
 */
public class S963 {
    class Solution {
        public double minAreaFreeRect(int[][] points) {
            // 四个点怎么组成矩形呢
            // 可以三重循环倒是
            // 不会做这一道题啊
            int max = 40000;
            Set<Integer> set = new HashSet<>();
            double minArea = Double.MAX_VALUE;
            for (int[] point1 : points) {
                for (int[] point2 : points) {
                    for (int[] point3 : points) {
                        if ((point3[1] - point1[1]) * (point2[1] - point1[1]) + (point3[0] - point1[0]) * (point2[0] - point1[0]) == 0) {
                            if (set.contains((point2[0] + point3[0] - point1[0]) * max + (point2[1] + point3[1] - point1[1]))) {
                                double a = Math.pow((point2[0] - point1[0]), 2) + Math.pow((point2[1] - point1[1]), 2);
                                double b = Math.pow((point3[0] - point1[0]), 2) + Math.pow((point3[1] - point1[1]), 2);
                                minArea = Math.min(minArea, Math.sqrt(a * b));
                            }
                        }
                        set.add(point3[0] * max + point3[1]);
                    }
                }
            }
            return minArea;
        }
    }
}
