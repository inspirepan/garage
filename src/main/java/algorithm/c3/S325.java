package algorithm.c3;

import java.util.HashMap;
import java.util.Map;

public class S325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;

        // sum, firstIndex
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                max = Math.max(i - map.get(sum - k), max);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}
