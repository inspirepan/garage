package algorithm.C3;

import java.util.HashMap;
import java.util.Map;

public class S350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 用map喽
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] result = new int[nums2.length];
        int index = 0;
        for (int k : nums2) {
            int times = 0;
            if (map.containsKey(k) && (times = map.get(k)) > 0) {
                result[index++] = k;
                map.put(k, times - 1);
            }
        }
        int[] r = new int[index];
        System.arraycopy(result, 0, r, 0, index);
        return r;
    }
}
