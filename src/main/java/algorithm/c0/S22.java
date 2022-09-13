package algorithm.c0;

import java.util.ArrayList;
import java.util.List;

public class S22 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        dfs(n, 0);
        return res;
    }

    void dfs(int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append("(");
            dfs(left - 1, right + 1);
            sb.setLength(sb.length() - 1);
        }
        if (right > 0) {
            sb.append(")");
            dfs(left, right - 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
