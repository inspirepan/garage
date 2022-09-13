package algorithm.f2;

import java.util.TreeSet;

public class S57 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + (long) t) {
                return true;
            }

            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + (long) t) {
                return true;
            }

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
