package algorithm.f2;

import java.util.HashMap;
import java.util.Map;

public class S119 {
    public int longestConsecutive(int[] nums) {
        // 可以用Map
        // 不应该保存长度、应该保存的是边界！
        // 这道题也可以用并查集，晕
        Map<Integer, Integer> upMap = new HashMap<>();
        Map<Integer, Integer> downMap = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            if (upMap.containsKey(n)) {
                continue;
            }
            // 尝试把上下连接起来
            int up = n;
            int down = n;
            // 上界
            if (upMap.containsKey(n + 1)) {
                up = upMap.get(n + 1);
            }
            // 下界
            if (downMap.containsKey(n - 1)) {
                down = downMap.get(n - 1);
            }
            int len = up - down + 1;
            upMap.put(n, up);
            downMap.put(n, down);
            // 应该一直往上\下传
            downMap.put(up, down);
            upMap.put(down, up);
            max = Math.max(max, len);
        }
        return max;
    }
}
