package algorithm.F1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S38 {
    List<String> result = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        dfs("", used, chars);

        return result.toArray(new String[result.size()]);
    }

    private void dfs(String path, boolean[] used, char[] chars) {
        System.out.println(path);
        if (path.length() == chars.length) result.add(path);
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && used[i - 1]) continue;
            used[i] = true;
            dfs(path + chars[i], used, chars);
            used[i] = false;
        }
    }
}
