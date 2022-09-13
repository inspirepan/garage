package algorithm.C5;

import java.util.HashMap;
import java.util.Map;

public class S594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num - 1)) {
                max = Math.max(max, map.get(num) + map.get(num - 1));
            }
            // 只需要+1或者-1扫一次就行了
        }
        return max;
    }
}
