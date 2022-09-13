package algorithm.C1;

import java.util.List;

public class S139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 比较简单的动态规划
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
}