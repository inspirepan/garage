package algorithm;

import java.util.TreeMap;

public class S854 {
    public boolean canReorderDoubled(int[] arr) {
        // 对于每一个元素，需要另一个元素和它配对 *2或者/2
        // 考虑正负两种情况
        // 用map统计数量
        // 然后从两种情况的绝对值最小的开始往上找，依次抵消掉，最后看是否有剩余的
        // sortedMap treeMap
        int zeroCount = 0;
        TreeMap<Integer, Integer> pCount = new TreeMap<>();
        TreeMap<Integer, Integer> nCount = new TreeMap<>();
        for (int n : arr) {
            if (n == 0) zeroCount++;
            else if (n > 0) {
                pCount.put(n, pCount.getOrDefault(n, 0) + 1);
            } else {
                // 负数放入相反数
                n = -n;
                nCount.put(n, nCount.getOrDefault(n, 0) + 1);
            }
        }
        if ((zeroCount & 1) == 1) return false;
        // 贪心匹配
        for (var key : pCount.keySet()) {
            int val;
            if ((val = pCount.get(key)) == 0) continue;
            if (!pCount.containsKey(key * 2) || pCount.get(key * 2) < val) return false;
            int count = pCount.get(key * 2);
            pCount.put(key * 2, count - val);
        }

        for (var key : nCount.keySet()) {
            int val = nCount.get(key);
            if (val == 0) continue;
            if (!nCount.containsKey(key * 2) || nCount.get(key * 2) < val) return false;
            int count = nCount.get(key * 2);
            nCount.put(key * 2, count - val);
        }
        return true;
    }
}