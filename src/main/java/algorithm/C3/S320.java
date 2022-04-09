package algorithm.C3;

import java.util.ArrayList;
import java.util.List;

public class S320 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String word;

    public List<String> generateAbbreviations(String word) {
        // 实际上和字符串的内容没有关系
        this.word = word;
        dfs(0, false);
        dfs(0, true);
        return result;
    }

    void dfs(int start, boolean flag) {
        // flag:
        // true 字符
        // false 数字

        int len = word.length();
        if (start == len) {
            result.add(sb.toString());
            return;
        }
        if (flag) {
            for (int end = start + 1; end <= len; end++) {
                sb.append(word.substring(start, end));
                dfs(end, false);
                sb.setLength(sb.length() - end + start);
            }
        } else {
            for (int end = len; end > start; end--) {
                sb.append(end - start);
                dfs(end, true);
                // 数字不一定是一位的！
                sb.setLength(sb.length() - ((end - start) / 10 + 1));
            }
        }
    }
}
