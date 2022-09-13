package algorithm.F2;

import java.util.Arrays;

public class S94 {
    public int minCut(String s) {
        // 可以提前判断一下每一个子串是不是回文串
        char[] c = s.toCharArray();
        int len = c.length;

        boolean[][] isPalindrome = new boolean[len][len];
        // check if palindrome for substring i, j
        // odd
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < len) {
                if (c[left] == c[right]) {
                    isPalindrome[left][right] = true;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
        // even
        for (int i = 0; i < len - 1; i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < len) {
                if (c[left] == c[right]) {
                    isPalindrome[left][right] = true;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        int[] dp = new int[len + 1];
        Arrays.fill(dp, len - 1);
        // dp
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            if (isPalindrome[0][i - 1]) {
                dp[i] = 0;
            } else {
                for (int k = i - 1; k > 0; k--) {
                    if (isPalindrome[k][i - 1]) {
                        dp[i] = Math.min(dp[i], dp[k] + 1);
                    }
                }
            }
        }
        return dp[len];
    }
}
