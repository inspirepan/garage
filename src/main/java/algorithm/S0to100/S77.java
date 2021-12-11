package algorithm.S0to100;

import java.util.ArrayList;
import java.util.List;

public class S77 {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1, 0);
        return result;
    }

    void dfs(int n, int k, int start, int len) {
        if (len == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - k + len + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1, len + 1);
            path.remove(len);
        }
    }
}
