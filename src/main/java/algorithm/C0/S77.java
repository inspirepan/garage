package algorithm.C0;

import java.util.ArrayList;
import java.util.List;

public class S77 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    int N;
    int K;
    boolean[] used;

    public List<List<Integer>> combine(int n, int k) {
        N = n;
        K = k;
        used = new boolean[N];
        dfs(1);
        return result;
    }

    private void dfs(int start) {
        if (path.size() == K) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i <= N; i++) {
            path.add(i);
            dfs(i + 1);
            path.remove(path.size() - 1);
        }
    }
}
