package algorithm.c6;

import java.util.HashMap;
import java.util.Map;

public class S666 {
    private int res;
    // depth+pos, value
    private final Map<Integer, Integer> map = new HashMap();

    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int num : nums) {
            int d = num / 100;
            int p = (num / 10) % 10;
            int v = num % 10;
            int pos = (int) Math.pow(2, d - 1) + p - 1;
            map.put(pos, v);
        }
        dfs(1, 0);
        return res;
    }

    private void dfs(int i, int pathSum) {
        if (!map.containsKey(i)) {
            return;
        }
        pathSum += map.get(i);
        if (!map.containsKey(2 * i) && !map.containsKey(2 * i + 1))  // 叶子
        {
            res += pathSum;
        }
        if (map.containsKey(2 * i)) {
            dfs(2 * i, pathSum);
        }
        if (map.containsKey(2 * i + 1)) {
            dfs(2 * i + 1, pathSum);
        }
    }
}
