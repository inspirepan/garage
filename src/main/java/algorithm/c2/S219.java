package algorithm.c2;

import java.util.HashMap;

/**
 * @author panjx
 */
public class S219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 太妙了
            Integer last = map.put(nums[i], i);
            if (last != null && i - last <= k) {
                return true;
            }
        }
        return false;
    }
}
