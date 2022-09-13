package algorithm.c4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S447 {
    public int numberOfBoomerangs(int[][] points) {
        // 需要考虑顺序
        // 统计每一个point到其他point的距离，同一个距离有n个的话，那么有n(n-1)的回旋镖
        List<Map<Integer, Integer>> maps = new ArrayList<>();
        int len = points.length;
        for (int i = 0; i < len; i++) {
            maps.add(new HashMap<>());
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int distance = dx * dx + dy * dy;
                var mapI = maps.get(i);
                var mapJ = maps.get(j);
                mapI.put(distance, mapI.getOrDefault(distance, 0) + 1);
                mapJ.put(distance, mapJ.getOrDefault(distance, 0) + 1);
            }
        }
        int count = 0;
        for (var map : maps) {
            for (var entry : map.entrySet()) {
                count += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return count;
    }
}
