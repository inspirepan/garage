package algorithm.S201to300;

import java.util.ArrayList;
import java.util.List;

public class S216 {
    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return result;
    }

    private void dfs(int k, int n, int start) {
        if (path.size() == k && sum == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (sum + i > n) {
                return;
            }
            sum += i;
            path.add(i);
            dfs(k, n, i + 1);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}
