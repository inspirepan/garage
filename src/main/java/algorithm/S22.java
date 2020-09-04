package algorithm;

import java.util.ArrayList;
import java.util.List;

public class S22 {
    private final List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, "", n, 0, n);
        return result;
    }

    private void dfs(int p, String path, int leftCount, int rightCount, int n) {
        if (p == 2 * n) {
            if (leftCount == 0 && rightCount == 0) {
                result.add(path);
            }
            return;
        }
        if (leftCount > 0) {
            var s = path.concat("(");
            dfs(p + 1, s, leftCount - 1, rightCount + 1, n);
        }
        if (rightCount > 0) {
            var s = path.concat(")");
            dfs(p + 1, s, leftCount, rightCount - 1, n);
        }
    }
}
