package algorithm.c2;

public class S214 {
    /**
     * 暴力判断回文串
     */
    public String shortestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        var chars = s.toCharArray();
        int i = chars.length - 1;
        while (i > 0 && !isPalindrome(chars, i)) {
            i--;
        }
        return new StringBuilder(s.substring(i + 1)).reverse().append(s).toString();
    }

    private boolean isPalindrome(char[] chars, int i) {
        int l = 0;
        while (l < i) {
            if (chars[l++] != chars[i--]) {
                return false;
            }
        }
        return true;
    }
}
