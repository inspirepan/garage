package algorithm;

import java.util.List;

public class S139 {
    public boolean wordBreak2(String s, List<String> wordDict) {

    }

    /* 回溯，超时暴毙 */
    private String s;
    private int len;
    private List<String> wordDict;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        this.s = s;
        this.len = s.length();
        this.wordDict = wordDict;
        return dfs(0);
    }

    private boolean dfs(int start) {
        if (start == len) {
            return true;
        }
        for (int i = start; i < len; i++) {
            String sub = s.substring(start, i + 1);
            if (wordDict.contains(sub)) {
                if (dfs(i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}