package algorithm.c5;

import java.util.HashMap;
import java.util.Map;

public class S560 {
    public int subarraySum(int[] nums, int k) {
        // 前缀和
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
