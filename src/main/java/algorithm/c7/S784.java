package algorithm.c7;

import java.util.ArrayList;
import java.util.List;

public class S784 {

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCasePermutation(String s) {
        char[] arr = s.toCharArray();
        dfs(0, arr);
        return res;
    }

    void dfs(int start, char[] arr) {
        if (start == arr.length) {
            res.add(sb.toString());
            return;
        }

        char c = arr[start];
        if (c >= '0' && c <= '9') {
            sb.append(c);
            dfs(start + 1, arr);
            sb.setLength(start);
        } else {
            sb.append(Character.toUpperCase(c));
            dfs(start + 1, arr);
            sb.setLength(start);
            sb.append(Character.toLowerCase(c));
            dfs(start + 1, arr);
            sb.setLength(start);
        }
    }
}
