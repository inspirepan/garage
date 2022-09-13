package algorithm.f2;

import java.util.TreeMap;

public class S08 {
    public int minSubArrayLen(int target, int[] nums) {
        // 没有负数元素
        int minLength = Integer.MAX_VALUE;
        // sum, index
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int t = sum - target;
            Integer k = map.floorKey(t);
            if (k != null) {
                int index = map.get(k);
                minLength = Math.min(minLength, i - index);
            }
            map.put(sum, i);
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
