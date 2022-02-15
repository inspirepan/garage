package algorithm.C0;

import java.util.HashMap;
import java.util.Map;

public class S96 {

    private Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return numTrees(1, n);
    }

    private int numTrees(int start, int end) {
        if (start > end) {
            return 1;
        }
        if (start == end) {
            return 1;
        }
        if (map.containsKey(end - start)) {
            return map.get(end - start);
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += numTrees(start, i - 1) * numTrees(i + 1, end);
        }
        map.put(end - start, count);
        return count;
    }
}
