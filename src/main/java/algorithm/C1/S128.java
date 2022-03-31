package algorithm.C1;

import java.util.HashMap;
import java.util.Map;

public class S128 {

    public int longestConsecutive(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int currentLength = 1 + left + right;
                max = Math.max(currentLength, max);
                map.put(num, currentLength);
                map.put(num - left, currentLength);
                map.put(num + right, currentLength);
            }
        }
        return max;
    }
}