package algorithm.c6;

public class S680 {
    public boolean validPalindrome(String s) {
        return helper(s, false);
    }

    private boolean helper(String s, boolean ignored) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (ignored) {
                    return false;
                } else {
                    return helper(s.substring(l + 1, r + 1), true)
                        || helper(s.substring(l, r), true);
                }
            }
        }
        return true;
    }
}
