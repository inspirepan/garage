package algorithm.C3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S356 {
    public boolean isReflected(int[][] points) {
        // 先求x的最大和最小值，必须匹配，找到中心的x坐标
        int minX = points[0][0];
        int maxX = points[0][0];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            var set = map.getOrDefault(p[0], new HashSet<>());
            set.add(p[1]);
            map.put(p[0], set);
        }
        int sum = minX + maxX;

        for (int[] p : points) {
            if (!map.containsKey(sum - p[0]) || !map.get(sum - p[0]).contains(p[1])) return false;
        }
        return true;
    }
}
