package algorithm.F2;

public class S87 {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 < len2) {
            return 0;
        }
        if (len1 == len2) {
            if (t.equals(s)) {
                return 1;
            } else {
                return 0;
            }
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            // 匹配0个都是1种
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len1; i++) {
            char curr = c1[i - 1];
            for (int j = 1; j <= len2; j++) {
                if (curr == c2[j - 1]) {
                    // 当前位置可以匹配一个字符
                    // 可以和前一个匹配重复的
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 无法多匹配，和前一个位置的结果一样
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}
