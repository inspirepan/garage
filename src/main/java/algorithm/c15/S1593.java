package algorithm.c15;

import java.util.HashSet;
import java.util.Set;

public class S1593 {
    private int max = 0;

    public int maxUniqueSplit(String s) {
        dfs(0, s, new HashSet<>());
        return max;
    }

    private void dfs(int start, String s, Set<String> set) {
        if (start == s.length()) {
            max = Math.max(max, set.size());
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (set.contains(sub)) {
                continue;
            }
            set.add(sub);
            dfs(i, s, set);
            set.remove(sub);
        }
    }
}
