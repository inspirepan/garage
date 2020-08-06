package algorithm;

import java.util.HashSet;
import java.util.List;

public class S139 {
    /* 暴力动态规划，官方题解 */
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        this.wordDictSet = new HashSet<>(wordDict);
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    /* 动态规划，按词典遍历，因为在s很长的时候，直接拆分要考虑的情况太多了，相比之下直接遍历词典会简便很多 */
    public boolean wordBreak3(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (String str : wordDict) {
                int subLength = str.length();
                if (subLength <= i && dp[i - subLength] && s.substring(i - subLength, i).equals(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    /* 直接回溯，超时暴毙，需要剪枝 */
    private String s;
    private int len;
    private HashSet<String> wordDictSet;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        this.s = s;
        this.len = s.length();
        this.wordDictSet = new HashSet<>(wordDict);
        return dfs(0);
    }

    private boolean dfs(int start) {
        if (start == len) {
            return true;
        }
        for (int i = start; i < len; i++) {
            String sub = s.substring(start, i + 1);
            if (wordDictSet.contains(sub)) {
                if (dfs(i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}