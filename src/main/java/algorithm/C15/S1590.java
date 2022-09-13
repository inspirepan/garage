package algorithm.C15;

import java.util.HashMap;
import java.util.Map;

public class S1590 {
    public int minSubarray(int[] nums, int p) {
        long count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] %= p;
            count = (count + (long) nums[i]) % p;
        }
        int remove = (int) count % p;
        if (remove == 0) {
            return 0;
        }
        // 需要在nums中找到一个最短的子数组的和
        int minLen = len;
        long sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put((long) 0, 0);
        // 贪心，保存每种余数的最近位置=
        for (int i = 1; i <= len; i++) {
            sum = (sum + (long) nums[i - 1]) % p;
            long t = (sum - (long) remove + p) % p;
            if (map.containsKey(t)) {
                minLen = Math.min(minLen, i - map.get(t));
            }
            map.put(sum % p, i);
        }
        return minLen == len ? -1 : minLen;
    }
}
