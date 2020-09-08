package algorithm;

import java.util.ArrayList;
import java.util.List;

public class S77 {
    private final List<List<Integer>> result = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1, 0);
        return result;
    }

    private void dfs(int n, int k, int s, int len) {
        if (len == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        int left = k - len;
        for (int i = s + 1; i <= n - left + 1; i++) {
            path.add(i);
            dfs(n, k, i, len + 1);
            path.remove(len);
        }
    }
}
