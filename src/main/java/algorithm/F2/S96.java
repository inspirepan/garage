package algorithm.F2;

public class S96 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        int k = 0;
        while (k < len1 && c3[k] == c1[k]) {
            dp[++k][0] = true;
        }
        k = 0;
        while (k < len2 && c3[k] == c2[k]) {
            dp[0][++k] = true;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (dp[i - 1][j] && c1[i - 1] == c3[i + j - 1]) {
                    dp[i][j] = true;
                }
                if (dp[i][j - 1] && c2[j - 1] == c3[i + j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[len1][len2];
    }
}
