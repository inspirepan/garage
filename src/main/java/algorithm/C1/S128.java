package algorithm.C1;

import java.util.HashMap;
import java.util.Map;

public class S128 {
    // Map: number, max length that could extend
    private final Map<Integer, Integer> map = new HashMap<>();
    private int maxLength = 0;

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int currentLength = 1 + left + right;
                maxLength = Math.max(currentLength, maxLength);
                map.put(num, currentLength);
                map.put(num - left, currentLength);
                map.put(num + right, currentLength);
            }
        }
        return maxLength;
    }
}