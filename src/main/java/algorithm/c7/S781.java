package algorithm.c7;

import java.util.HashMap;
import java.util.Map;

public class S781 {
    public int numRabbits(int[] answers) {
        // 只需要考虑回答相同数量的兔子，最少有几个颜色
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : answers) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for (var e : map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            int group = val / (key + 1);
            if (val % (key + 1) > 0) {
                group++;
            }
            count += (key + 1) * group;
            // 每个key最多key+1只兔子为一组
        }
        return count;
    }
}
