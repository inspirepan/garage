package algorithm.C3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class S377 {
    // 因为target是已知的，其实可以用target大小的数组的，不需要用Map
    private Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        // 直接递归超时了
        if (map.containsKey(target)) return map.get(target);
        if (target <= 0) return 0;
        int count = 0;
        for (int num : nums) {
            if (target == num) count += 1;
            else if (target > num) {
                count += combinationSum4(nums, target - num);
            }
        }
        map.put(target, count);
        return count;
    }
}
