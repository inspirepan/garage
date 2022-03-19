package algorithm.C6;

import java.util.List;

public class S624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = 10000;
        int max = -10000;
        int result = 0;
        // min和max要来自不同的数组
        for (var array : arrays) {
            result = Math.max(result, Math.max(max - array.get(0), array.get(array.size() - 1) - min));
            min = Math.min(min, array.get(0));
            max = Math.max(max, array.get(array.size() - 1));
        }
        return result;
    }
}
