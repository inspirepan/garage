package algorithm.c5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S554 {
    public int leastBricks(List<List<Integer>> wall) {
        // 记录每一个缝隙出现的频率，出现次数最多的缝隙
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (var row : wall) {
            int sum = 0;
            // 无视最后一个
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                int freq = map.getOrDefault(sum, 0) + 1;
                max = Math.max(max, freq);
                map.put(sum, freq);
            }
        }
        return wall.size() - max;
    }
}
