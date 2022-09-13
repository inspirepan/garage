package algorithm.c0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S40 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target);
        return result;
    }

    void dfs(int start, int[] c, int target) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < c.length; i++) {
            if (i > start && c[i] == c[i - 1]) {
                continue;
            }
            if (c[i] > target) {
                continue;
            }

            target -= c[i];
            path.add(c[i]);
            dfs(i + 1, c, target);
            target += c[i];
            path.remove(path.size() - 1);
        }
    }
}
