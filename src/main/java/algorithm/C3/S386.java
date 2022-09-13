package algorithm.C3;

import java.util.ArrayList;
import java.util.List;

public class S386 {
    private final List<Integer> result = new ArrayList<>();
    private int n;

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        for (int i = 1; i <= 9; i++) {
            dfs(i);
        }
        return result;
    }

    private void dfs(int v) {
        if (v <= n) {
            result.add(v);
            for (int i = 0; i <= 9; i++) {
                dfs(10 * v + i);
            }
        }
    }
}
