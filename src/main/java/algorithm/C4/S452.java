package algorithm.C4;

import java.security.cert.PolicyNode;
import java.util.Arrays;

public class S452 {
    public int findMinArrowShots(int[][] points) {
        // 按照初始位置排序
        if (points.length <= 1) return points.length;
        Arrays.sort(points, (a, b) -> a[0] > b[0] ? 1 : -1);
        long end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            int[] p = points[i];
            if (p[0] > end) {
                count++;
                end = p[1];
            } else {
                // 可以共用一根箭
                end = Math.min(p[1], end);
            }
        }
        return count;
    }
}
