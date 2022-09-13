package algorithm.f1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S38 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        dfs(used, chars);
        return result.toArray(new String[result.size()]);
    }

    private void dfs(boolean[] used, char[] chars) {
        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            // 之前剪枝剪错了，应该是前一个和这个一样、并且没有使用过，才剪掉
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sb.append(chars[i]);
            dfs(used, chars);
            used[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }
}