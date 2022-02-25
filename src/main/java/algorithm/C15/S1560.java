package algorithm.C15;

import java.util.ArrayList;
import java.util.List;

public class S1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        // 只和起点终点有关
        int start = rounds[0];
        int dest = rounds[rounds.length - 1];

        List<Integer> result = new ArrayList<>();
        if (dest > start) {
            int i = start;
            while (i <= dest) result.add(i++);
        } else if (dest == start) {
            result.add(dest);
        } else {
            int i = 1;
            while (i <= n) {
                result.add(i);
                if (++i > dest && i < start) {
                    i = start;
                }
            }
        }
        return result;
    }
}
