package algorithm.C2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S254 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2);
        return res;
    }

    void dfs(int n, int x) {
        if (n == 1) {
            return;
        }
        if (!path.isEmpty()) {
            path.add(n);
            res.add(new ArrayList<>(path));
            path.removeLast();
        }
        for (int i = x; i * i <= n; i++) {
            if (n % i == 0) {
                path.add(i);
                dfs(n / i, i);
                path.removeLast();
            }
        }
    }
}
