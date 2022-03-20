package algorithm.C6;

public class S680 {
    public boolean validPalindrome(String s) {
        // 从左右往里面缩
        if (s.length() <= 2) return true;
        char[] c = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (c[left] == c[right]) {
                left++;
                right--;
            } else {
                return helper(c, left + 1, right) || helper(c, left, right - 1);
            }
        }
        return true;
    }

    private boolean helper(char[] c, int left, int right) {
        while (left < right) {
            if (c[left++] != c[right--]) return false;
        }
        return true;
    }
}
