package algorithm;

public class S5 {
    /**
     * 动态规划，很耗时
     * O(N^2)，
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // 从i到j的字符串是不是回文串
        boolean[][] dp = new boolean[len][len];
        int left = 0;
        int right = 1;
        for (int interval = 0; interval < len; interval++) {
            int j = 0;
            while (j + interval < len) {
                // 单独的字符都是回文串
                if (interval == 0) {
                    dp[j][j] = true;
                }
                // 两个连在一起的字符串是不是回文串（即两个字符是不是相同）
                if (interval == 1 && s.charAt(j) == s.charAt(j + 1)) {
                    dp[j][j + 1] = true;
                    left = j;
                    right = j + 2;
                }
                // 扩散一次，记录结果
                if (interval >= 2) {
                    boolean palindrome = dp[j + 1][j + interval - 1] && s.charAt(j) == s.charAt(j + interval);
                    dp[j][j + interval] = palindrome;
                    if (palindrome) {
                        left = j;
                        right = j + interval + 1;
                    }
                }
                j++;
            }
        }
        return s.substring(left, right);
    }

    /**
     * 中心扩散 2ms
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        if (s.length() == 0) {
            return s;
        }
        int[] se = new int[2];
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            i = find(c, i, se);
        }
        return s.substring(se[0], se[1] + 1);

    }

    public int find(char[] c, int left, int[] se) {

        int right = left;
        while (right + 1 < c.length && c[right + 1] == c[right]) {
            right++;
        }

        int mid = right;
        while (left > 0 && right + 1 < c.length && c[left - 1] == c[right + 1]) {
            left--;
            right++;
        }
        if (right - left > se[1] - se[0]) {
            se[0] = left;
            se[1] = right;
        }

        return mid;

    }
}
