package algorithm.f1;

import java.util.ArrayList;
import java.util.List;

public class S57II {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        for (int l = 1, r = 1, sum = 0; r < target; r++) {
            sum += r;
            while (sum > target) {
                sum -= l;
                l++;
            }
            if (sum == target) {
                int[] t = new int[r - l + 1];
                for (int i = 0; i < t.length; i++) {
                    t[i] = i + l;
                }
                res.add(t);
            }
        }
        int[][] result = new int[res.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}

