package algorithm.C2;

import java.util.ArrayList;
import java.util.List;

public class S247 {
    private static final char[][] map = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    public List<String> findStrobogrammatic(int n) {
        List<String> ansList = new ArrayList<>();
        dfs(ansList, new char[n], 0, n - 1);
        return ansList;
    }

    private void dfs(List<String> ansList, char[] ans, int left, int right) {
        if (left > right) {
            ansList.add(String.valueOf(ans));
            return;
        }
        if (left == right) {
            for (int i = 0; i < 3; i++) {
                ans[left] = map[i][0];
                dfs(ansList, ans, left + 1, right - 1);
            }
            return;
        }
        // 如果 left == 0，那么就要跳过 '0' 的情况（因为前导零是非法的）
        int i = left > 0 ? 0 : 1;
        for (; i < 5; i++) {
            ans[left] = map[i][0];
            ans[right] = map[i][1];
            dfs(ansList, ans, left + 1, right - 1);
        }
    }
}
