package algorithm.c0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S39 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            if (c > target) {
                continue;
            }
            target -= c;
            path.addLast(c);
            dfs(candidates, target, i);
            path.removeLast();
            target += c;
        }
    }
}
