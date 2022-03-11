package algorithm.C5;

import playground.ArrayUtils;

import java.util.Arrays;

/**
 * @author panjx
 */
public class S516 {
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        // i到j的子字符串的最长回文子序列之长度
        int[][] dp = new int[len][len];
        for (int j = 0; j < len; j++) {
            dp[j][j] = 1;
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 2 :
                        Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][len - 1];
    }

    public static int longestPalindromeSubseq2(String s) {
        int len = s.length();
        // 0~i的子字符串的回文子序列最大长度1
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = len - 1; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < len; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = pre + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = temp;
            }
        }
        return dp[len - 1];
    }
}
